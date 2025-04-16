package kr.ac.hansung.cse.controller;

// 클라이언트 요청 정보를 받기 위해 HttpServletRequest 사용
import jakarta.servlet.http.HttpServletRequest;

// 로그를 출력하기 위한 SLF4J Logger
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 해당 클래스를 Spring MVC의 컨트롤러로 등록하기 위한 어노테이션
import org.springframework.stereotype.Controller;

// HTTP GET 요청을 처리하기 위한 어노테이션
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  // 이 클래스가 Spring MVC에서 요청을 처리하는 컨트롤러임을 나타냄
public class HomeController {

    // Logger 객체 생성: 로그를 남길 때 사용
    // LoggerFactory.getLogger()에 클래스명을 넣으면, 해당 클래스 기준으로 로그를 출력함
    private static final Logger logger = LoggerFactory.getLogger("kr.ac.hansung.controller.HomeController");

    // "/" 경로로 들어온 GET 요청을 처리함
    // 브라우저에서 http://localhost:8080/ 으로 접속했을 때 이 메서드가 실행됨
    //@RequestMapping(value = "/", method = RequestMethod.GET) -> GET 방식이므로, @GetMapping 으로 간결하게 표현 가능
    @GetMapping("/")
    public String home(HttpServletRequest request) {

        // 요청 URL을 문자열로 추출
        String url = request.getRequestURL().toString();

        // 클라이언트의 IP 주소 추출
        String clientIPaddr = request.getRemoteAddr();

        // 로그 출력 (콘솔 또는 파일에 저장됨)
        logger.info("Request URL: {}, Client IP: {}", url, clientIPaddr);

        // "home"이라는 뷰 이름을 반환 → /WEB-INF/views/home.jsp 로 포워딩됨
        return "home";
    }
}