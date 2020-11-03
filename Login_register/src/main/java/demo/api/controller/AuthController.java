package demo.api.controller;
import demo.api.exception.AuthException;
import demo.api.exception.common.ExceptionCreater;
import demo.api.exception.common.ServerException;
import demo.api.model.UserModel;
import demo.api.model.entities.User;
import demo.api.response.BaseResponse;
import demo.api.response.RestAPIResponse;
import demo.api.token.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/edu/auth")
public class AuthController extends BaseController {

    @Autowired
    private UserModel authModel;


    @RequestMapping(value = "/login-user", method = RequestMethod.POST, headers = "Accept=application/json")
    public RestAPIResponse loginAccount(@RequestBody User user) throws ServerException {
        BaseResponse<AccessToken> result = authModel.loginUser(user);
        if (result.isSuccess()) {
            return RestAPIResponse.fromData(result.getResponse());
        }
        throw ExceptionCreater.createServerException(new AuthException(result.getMessage()));
    }

    @RequestMapping(value = "/register-user", method = RequestMethod.POST, headers = "Accept=application/json")
    public RestAPIResponse registerAccount(@RequestBody User user) throws ServerException {
        BaseResponse<AccessToken> result = authModel.registerUser(user);
        if (result.isSuccess()) {
            return RestAPIResponse.fromData(result.getResponse());
        }
        throw ExceptionCreater.createServerException(new AuthException(result.getMessage()));
    }

}
