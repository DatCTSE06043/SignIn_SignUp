package demo.api.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;


public class RestAPIResponse<T> extends ResponseEntity<Response<T>> {

    private RestAPIResponse(HttpStatus status) {
        super(status);
    }


    private RestAPIResponse(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    private RestAPIResponse(Response<T> body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }

    public RestAPIResponse(T data) {
        super(new Response<T>(data), HttpStatus.OK);
    }

    public RestAPIResponse(T data, HttpStatus status) {
        super(new Response<T>(data), status);
    }

    public RestAPIResponse(Response<T> body, HttpStatus status) {
        super(body, status);
    }

    public static <D> RestAPIResponse<D> fromData(D data) {
        return new RestAPIResponse<D>(data);
    }
}
