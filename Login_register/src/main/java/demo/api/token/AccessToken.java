package demo.api.token;

/**
 * Created by tuanle on 1/9/18.
 */
public class AccessToken {

    private String accessToken;

    private String refreshToken;

    private long expired;

    public AccessToken() {

    }

    public AccessToken(String accessToken, long expired) {
        this.accessToken = accessToken;
        this.expired = expired;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public long getExpired() {
        return expired;
    }

}
