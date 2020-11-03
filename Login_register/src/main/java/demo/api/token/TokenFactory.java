package demo.api.token;

import demo.api.model.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;


public class TokenFactory {

    public static AccessToken createAccessToken(User user) {
        LocalDateTime currentTime = LocalDateTime.now();
        long expired = System.currentTimeMillis() + TokenConfig.getTokenExpireTime() * 60 * 1000;
        String token = Jwts.builder()
                .setClaims(ClaimsUtils.createClaims(user))
                .setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
//                .setExpiration(Date.from(currentTime
//                        .plusMinutes(TokenConfig.getTokenExpireTime())
//                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, TokenConfig.getSecureKey())
                .compact();
        return createRefreshToken(user, new AccessToken(token, expired));
    }

    private static AccessToken createRefreshToken(User user, AccessToken token) {
        LocalDateTime currentTime = LocalDateTime.now();
        String refreshToken = Jwts.builder()
                .setClaims(ClaimsUtils.createClaims(user))
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(currentTime
                        .plusMinutes(TokenConfig.getRefreshTokenExpireTime())
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, TokenConfig.getSecureKey())
                .compact();
        token.setRefreshToken(refreshToken);
        return token;
    }
}
