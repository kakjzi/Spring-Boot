package hello.core.scan.filter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterConfigTest {

    @Test
    @DisplayName("컴포넌트 필터 설정")
    void filterScan() {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        //when
        BeanA beanA = ac.getBean("beanA", BeanA.class);

        //then
        assertThat(beanA).isNotNull(); //값 조회 여부

        assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class)
        );

    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(classes = MyIncludeComponent.class), //스프링빈 등록 o
            excludeFilters = @Filter(classes = MyExcludeComponent.class) //스프링빈 등록 x
    )
    static class ComponentFilterAppConfig {

    }
}
