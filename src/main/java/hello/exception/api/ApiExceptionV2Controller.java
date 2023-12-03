package hello.exception.api;


import hello.exception.exception.UserException;
import hello.exception.exhandler.ErrorResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController // body에 바로 찍히는 것
public class ApiExceptionV2Controller {

    @GetMapping("/api3/members/{id}")
    public ApiExceptionController.MemberDto getMember(@PathVariable("id") String id) {
        if (id.equals("ex")) {
            throw new RuntimeException("잘못된 사용자");
        }

        if(id.equals("bad")){
            throw new IllegalArgumentException("잘못된 입력 값"); // 예외 처리는 무조건 throw로 던져야한다. 주의
        }

        if (id.equals("user-ex")) {
            throw new UserException();
        }

        return new ApiExceptionController.MemberDto(id,"hello" + id);
    }

    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String memberId;
        private String name;
    }
}
