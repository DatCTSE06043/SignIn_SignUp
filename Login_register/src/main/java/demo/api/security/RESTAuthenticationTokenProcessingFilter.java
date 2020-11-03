package demo.api.security;

/**
 * Created by tuanle on 1/5/18.
 */


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.api.constant.Message;
import demo.api.exception.common.ExceptionCreater;
import demo.api.model.entities.ErrorMessage;
import demo.api.response.Response;
import demo.api.token.ClaimsUtils;
import demo.api.token.TokenConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class RESTAuthenticationTokenProcessingFilter extends GenericFilterBean {

    private static final String SNS_CERT = "Zxczjahsduqweozasdkluiqweuhskadsasd";

    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        if (((HttpServletRequest) req).getRequestURL().toString().contains("/sns/message")) {
            final String certificate = request.getHeader("certificate");
            final String bot = request.getHeader("bot");

            if ("OPTIONS".equals(request.getMethod())) {
                response.setStatus(HttpServletResponse.SC_OK);

                chain.doFilter(req, res);
            } else {

                if (!SNS_CERT.equals(certificate)) {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.getWriter().write(getReturnAuthErrorString());
                    return;
                }
                int storeId;
                try {
                    storeId = Integer.parseInt(bot);
                } catch (Exception ex) {
                    response.setStatus(HttpStatus.BAD_REQUEST.value());
                    response.getWriter().write(getReturnAuthErrorString());
                    return;
                }

                req.setAttribute(ClaimsUtils.STORE_ID_KEY, storeId);

                chain.doFilter(req, res);
            }
        } else {
            final String authHeader = request.getHeader("authorization");

            if ("OPTIONS".equals(request.getMethod())) {
                response.setStatus(HttpServletResponse.SC_OK);

                chain.doFilter(req, res);
            } else {

                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.getWriter().write(getReturnAuthErrorString());
                    return;
                }

                final String token = authHeader.substring(7);

                try {
                    final Claims claims = Jwts.parser().setSigningKey(TokenConfig.getSecureKey()).parseClaimsJws(token).getBody();
                    req.setAttribute(ClaimsUtils.USER_ID_KEY, ClaimsUtils.getUserId(claims));
                    req.setAttribute(ClaimsUtils.STORE_ID_KEY, ClaimsUtils.getStoreId(claims));
                    req.setAttribute(ClaimsUtils.APP_ID_KEY, ClaimsUtils.getAppId(claims));
                    JwtUtils.setClaimsKey(request, claims);

                } catch (final SignatureException e) {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.getWriter().write(getReturnAuthErrorString());
                    response.addHeader("Accept", "application/json");
                    response.addHeader("Content-Type", "application/json");
                    return;
                } catch (Exception ex) {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.getWriter().write(getReturnAuthErrorString());
                    response.addHeader("Accept", "application/json");
                    response.addHeader("Content-Type", "application/json");
                    return;
                }

                chain.doFilter(req, res);
            }
        }
    }

    private String getReturnAuthErrorString() throws JsonProcessingException {
        Response response = new Response(new ErrorMessage(Message.ERROR_INVALID_TOKEN, ExceptionCreater.AUTH_ERROR));
        return convertObjectToJson(response);
    }

    private String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }


}