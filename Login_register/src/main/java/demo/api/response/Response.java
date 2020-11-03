package demo.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import demo.api.model.entities.ErrorMessage;

import java.io.Serializable;

/**
 * Created by tuanle on 1/8/18.
 */
public class Response<T> implements Serializable {
    private static final String RESULT_OK = "ok";
    private static final String RESULT_ERROR = "error";

    @JsonProperty("result")
    private final String result;

    @JsonProperty("data")
    private T data;

    @JsonProperty("error")
    private ErrorMessage error;

    public Response(T data) {
        this.result = RESULT_OK;
        this.data = data;
    }

    public Response(ErrorMessage error) {
        this.result = RESULT_ERROR;
        this.error = error;
    }


    public Response(){
        this.result = RESULT_OK;
    }
}
