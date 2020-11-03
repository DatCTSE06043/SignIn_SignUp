package demo.api.constant;

/**
 * Created by tuanle on 1/16/18.
 */
public class Message {

    // Common message
    public static final String PARSE_DATA_ERROR = "Parse data error";

    // Auth message error
    public static final String ERROR_INVALID_TOKEN = "Missing or invalid token";
    public static final String ERROR_LOGIN_REQUIRED_PRAM = "Email and password is required";
    public static final String ERROR_LOGIN_USER_NOT_FOUND = "User not found";
    public static final String ERROR_INVALID_REFRESH_TOKEN = "Invalid refresh token";
    public static final String ERROR_LOGIN_PASSWORD_INCORRECT  = "Password is incorrect.";

    // User message error
    public static final String ERROR_REGISTER_EMAIL_ALREADY_EXISTS = "Email already exists.";
    public static final String ERROR_USER_NOT_FOUND = "User not found";
    public static final String ERROR_USER_CURRENT_PASSWORD_INCORRECT  = "The current password is incorrect.";
    public static final String ERROR_USER_MULTIPART_FILE ="MultipartFile Error.";

    // Multipart error
    public static final String ERROR_MULTIPART_FILE = "MultipartFile Error.";
    public static final String ERROR_MULTIPART_FILE_NULL = "MultipartFile NULL.";

    // Product error
    public static final String ERROR_PRODUCT_NOT_FOUND = "Product not found.";
    public static final String ERROR_PRODUCT_UPLOAD_FAILED = "Upload product failed.";

    // User address
    public static final String ERROR_USER_ADDRESS_NOT_FOUND = "Address not found.";

    // Transaction
    public static final String ERROR_TRANSACTION_INFO_NOT_FOUND = "Transaction information not found.";

}
