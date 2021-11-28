package hello.core; //컴포넌트 스캔 기본값은 설정 정보 클래스의 패키지 위치가 시작위치가 됨.

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //스캔 대상 지정 basePackages
        basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)//@Configuration 이것도 컴포넌트 스캔이 되면서 스프링에 자동으로 등록되기 때문에 스캔대상에서 제외해주는 설정.
public class AutoAppConfig {

}
