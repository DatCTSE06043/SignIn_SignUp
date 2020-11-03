package demo.api.token;

import demo.api.security.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by tuanle on 1/24/18.
 */
public class AuthClaim {
    public static boolean isLogin(HttpServletRequest request) {
        if (request == null) {
            return false;
        }
        final String authHeader = request.getHeader("authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return false;
        }

        final String token = authHeader.substring(7);
        try {
            Jwts.parser().setSigningKey(TokenConfig.getSecureKey()).parseClaimsJws(token);
            return true;
        } catch (final SignatureException e) {
        } catch (Exception ex) {
        }
        return false;
    }

    public static long getUserId(HttpServletRequest request) {
        if (request == null) {
            return 0;
        }
        Claims claims = null;
        if (JwtUtils.isExistClaims(request)) {
            claims = JwtUtils.getClaims(request);
        } else {
            final String authHeader = request.getHeader("authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return 0;
            }

            final String token = authHeader.substring(7);
            try {
                claims = Jwts.parser().setSigningKey(TokenConfig.getSecureKey()).parseClaimsJws(token).getBody();

            } catch (final SignatureException e) {
            } catch (Exception ex) {
            }
        }
        if (claims != null) {
            return ClaimsUtils.getUserId(claims);
        }
        return 0;
    }
}
