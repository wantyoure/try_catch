package hello.exception.servlet;


import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Slf4j // log
@Controller
public class ServletExController {

    @GetMapping("/error-ex")
    public void errorEx() {
        throw  new RuntimeException("예외발생"); // RuntimeException 그냥 throw 로 던질 수 있따.
    }

    @GetMapping("/error-404")
    public void error404(HttpServletResponse response) throws IOException {
        response.sendError(404, "404 오류!"); //sendError : 우리가 상태코드를 바꿀 수 있다.
    }
    @GetMapping("/error-500")
    public void error500(HttpServletResponse response) throws IOException {
        response.sendError(500);
    }

    @GetMapping("/error-400")
    public void error400(HttpServletResponse response) throws IOException {
        response.sendError(400, "400 오류!"); //sendError : 우리가 상태코드를 바꿀 수 있다.
    }



}
