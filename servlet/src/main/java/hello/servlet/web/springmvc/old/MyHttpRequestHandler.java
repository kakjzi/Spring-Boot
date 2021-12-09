package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HandlerAdapter
 * 0 = RequestMappingHandlerAdapter : @RequestMapping
 * 1 = HttpRequestHandlerAdapter : HttpRequestHandler 처리
 * 2 = SimpleControllerHandlerAdapter : Controller 인터페이스 처리
 *
 * HandlerMapping
 * 0 = RequestMappingHandlerMapping : @RequestMapping
 * 1 = BeanNameUrlHandlerMapping : 스프링 빈의 이름으로 핸드러를 찾는다.
 */

@Component("/springmvc/request-handler")// BeanNameUrlHandlerMapping
public class MyHttpRequestHandler implements HttpRequestHandler { //HttpRequestHandlerAdapter
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }
}
