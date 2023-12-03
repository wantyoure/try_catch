package hello.exception.exhandler.advice;


import hello.exception.exception.UserException;
import hello.exception.exhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "hello.exception.api") // api에서 발생하는 예외를  따로 분리해서 만들 수 있따. / 특정 대상을 지목해서 쓸 수 있다.
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // 상태 코드도 우리가 바꿀 수 있다.
    @ExceptionHandler(IllegalArgumentException.class) // Api 처리 할 때 이렇게 ExceptionHandler 를 쓰면 된다.
    public ErrorResult illegalExHandler(IllegalArgumentException e) {
        log.info("[exceptionHandler] ex", e);
        return new ErrorResult("BAD", e.getMessage());
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResult> userExHandler(UserException e) {
        log.error("[exceptionHandler]",e);
        ErrorResult errorResult = new ErrorResult("USER-Ex", e.getMessage());
        return new ResponseEntity(errorResult, HttpStatus.BAD_REQUEST);
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 내부 에러
    @ExceptionHandler
    public ErrorResult exHandler(Exception e) {
        log.info("[exceptionHandler] ex", e);
        return new ErrorResult("EX", "내부 오류");
    }

}
