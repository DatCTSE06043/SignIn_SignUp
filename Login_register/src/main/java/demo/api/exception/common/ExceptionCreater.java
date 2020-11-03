package demo.api.exception.common;

import demo.api.model.entities.ErrorMessage;
import org.springframework.http.HttpStatus;

/**
 * Created by tuanle on 1/16/18.
 */
public class ExceptionCreater {

    //Common
    public static final String PARSE_DATA_ERROR = "parse_data_error";

    //Auth
    public static final String AUTH_ERROR = "auth_error";

    //User
    public static final String USER_ERROR = "user_error";

    //Multipart
    public static final String MULTIPART_ERROR = "multipart_error";

    // Product
    public static final String PRODUCT_ERROR = "product_error";

    // User Address
    public static final String USER_ADDRESS_ERROR = "user_address_error";

    // Transaction
    public static final String TRANSACTION_ERROR = "transaction_error";

    public static ServerException createServerException(IBaseException exception) {
        HttpStatus status = getHTTPStatusFromErrorCode(exception.getCode());
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), exception.getCode());
        return new ServerException(status, errorMessage);
    }

    private static HttpStatus getHTTPStatusFromErrorCode(String errorCode) {
        HttpStatus status;
        switch (errorCode) {
            default:
                status = HttpStatus.BAD_REQUEST;
                break;
        }
        return status;
    }
}
