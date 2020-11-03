package demo.api.response;



/**
 * Create by DaiKySy on 3/15/19.
 */
public class BaseResponse<D> extends MessageResponse {

    public BaseResponse() {
    }

    public BaseResponse(D response) {
        this.response = response;
    }

    private D response;

    public D getResponse() {
        return response;
    }

    public void setResponse(D response) {
        this.response = response;
    }

}
