package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


@Component("/springmvc/old-controller")// BeanNameUrlHandlerMapping

public class OldController implements Controller {  //SimpleControllerHandlerAdapter
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");

        //application.properties 설정에 뷰리졸버 정보 등록.
        return new ModelAndView("new-form");
    }
}
