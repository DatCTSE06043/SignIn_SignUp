package demo.api.token;


import demo.api.constant.Constants;
import demo.api.model.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


/**
 * Created by tuanle on 1/15/18.
 */
public class ClaimsUtils {

    public static final String USER_ID_KEY = "userId";

    public static final String STORE_ID_KEY = "storeId";

    public static final String APP_ID_KEY = "appId";

    private static final String USER_EMAIL_KEY = "sub";

    static Claims createClaims(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put(USER_ID_KEY, user.getId());
        /*claims.put(APP_ID_KEY, user.getAppId());
        if (user.getType() == Constants.UserType.STORE) {
            claims.put(STORE_ID_KEY, user.getStoreId());
        }*/
        return claims;
    }

    public static int getUserId(Claims claims) {
        return Integer.parseInt(claims.get(USER_ID_KEY).toString());
    }

    public static Integer getStoreId(Claims claims) {
        Object store = claims.get(STORE_ID_KEY);
        if (store != null) {
            return Integer.parseInt(store.toString());
        }
        return null;
    }
    public static Integer getAppId(Claims claims) {
        Object appId = claims.get(APP_ID_KEY);
        if (appId != null) {
            return Integer.parseInt(appId.toString());
        }
        return Constants.APP_ID_OLIOA;
    }

    public static String getEmail(Claims claims) {
        return claims.get(USER_EMAIL_KEY).toString();
    }

}
