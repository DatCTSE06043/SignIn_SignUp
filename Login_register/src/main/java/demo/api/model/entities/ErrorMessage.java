package demo.api.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tuanle on 1/16/18.
 */
public class ErrorMessage {

    public static final ErrorMessage UNKNOWN_ERROR = new ErrorMessage("An error occurred please try again later","unknown_error");

    @JsonProperty("message")
    private String message;

    @JsonProperty("error_code")
    private String errorCode;

    public ErrorMessage(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
