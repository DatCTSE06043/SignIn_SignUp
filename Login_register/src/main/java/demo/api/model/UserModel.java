package demo.api.model;


import demo.api.model.entities.User;
import demo.api.repository.UserRepository;
import demo.api.response.BaseResponse;
import demo.api.token.AccessToken;
import demo.api.token.TokenFactory;
import demo.api.untils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserModel extends BaseModel {

    public static final int LENGTH_CHECK_IN_CODE = 8;

    @Autowired
    private UserRepository userRepository;

    public BaseResponse<AccessToken> loginUser(User user) {
        BaseResponse<AccessToken> response = new BaseResponse<>(new AccessToken());
        if (!user.isValid()) {
            String passwordEncode = Utils.encodeMD5(user.getPassword());
            user = userRepository.findByUsernameAndPassword(user.getUsername(), passwordEncode);
            if (user == null) {
                response.setMessage(getString().accountNotExitsOrPasswordWrong);
            }
        } else {
            response.setMessage(getString().accountNull);
        }
        if (response.isSuccess()) {
            response.setResponse(TokenFactory.createAccessToken(user));
        }
        return response;
    }

    private boolean checkExitsUser(User user) {
        try {
            User account = userRepository.findByUsername(user.getUsername());
            return account != null;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.toString());
        }
    }

    public BaseResponse<AccessToken> registerUser(User user) {
        BaseResponse<AccessToken> response = new BaseResponse<>(new AccessToken());
        if (!user.isValidFull()) {
            if (checkExitsUser(user)) {
                response.setMessage(getString().accountExits);
                return response;
            } else {
                String passwordEncode = Utils.encodeMD5(user.getPassword());
                user.setPassword(passwordEncode);
                userRepository.save(user);
            }
        } else {
            response.setMessage(getString().accountNull);
            return response;
        }
        response.setResponse(TokenFactory.createAccessToken(user));
        return response;
    }

}
