package hello.exception.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "error.bad") // 400으로 바뀐다.  reason : 메세지를 남길 수 있다.
public class BadRequestException extends RuntimeException{


}
