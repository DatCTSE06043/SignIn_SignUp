package demo.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Create by DaiKySy on 3/12/19.
 */
public class MessageResponse {
    @JsonIgnore
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return message == null || message.isEmpty();
    }

}
