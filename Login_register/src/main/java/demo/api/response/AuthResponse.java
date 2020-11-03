package demo.api.response;

import com.google.gson.annotations.SerializedName;

/**
 * Create by DaiKySy on 3/12/19.
 */
public class AuthResponse {
    public AuthResponse(String accessToken, String refreshToken, long expired) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expired = expired;
    }

    @SerializedName("accessToken")
    private String accessToken;
    @SerializedName("refreshToken")
    private String refreshToken;
    @SerializedName("expired")
    private long expired;

}
