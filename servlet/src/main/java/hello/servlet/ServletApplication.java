package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan //서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}
	/*
	  뷰리졸버
	  application.properties 에서도 설정 가능.
	  1 = BeanNameViewResolver : 빈 이름으로 뷰를 찾아서 반환한다. (ex: 엑셀파일 생성기능)
	  2 = InternalResourceViewResolver : JSP 를 처리할 수 있는 뷰를 반환.
	 */

//	@Bean
//	ViewResolver internalResourceViewResolver(){
//		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
//	}
}