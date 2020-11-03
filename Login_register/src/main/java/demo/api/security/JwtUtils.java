package demo.api.security;

import io.jsonwebtoken.Claims;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tuanle on 1/15/18.
 */
public class JwtUtils {
    private static String CLAIMS_KEY = "claims";

    public static Claims getClaims(HttpServletRequest request) {
        return (Claims) request.getAttribute(CLAIMS_KEY);
    }

    protected static void setClaimsKey(HttpServletRequest request, Claims claims) {
        request.setAttribute(CLAIMS_KEY, claims);
    }

    public static boolean isExistClaims(HttpServletRequest request) {
        return request.getAttribute(CLAIMS_KEY) != null;
    }
}
