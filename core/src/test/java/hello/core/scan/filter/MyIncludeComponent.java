package hello.core.scan.filter;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent { // 의미: 컴포넌트 스캔에 추가할꺼야~

}
