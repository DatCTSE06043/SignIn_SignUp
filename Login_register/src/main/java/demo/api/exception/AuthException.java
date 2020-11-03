package demo.api.exception;

import demo.api.exception.common.ExceptionCreater;
import demo.api.exception.common.IBaseException;

/**
 * Created by tuanle on 1/16/18.
 */
public class AuthException implements IBaseException {
    private String message;

    public AuthException(String message){
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getCode() {
        return ExceptionCreater.AUTH_ERROR;
    }
}
