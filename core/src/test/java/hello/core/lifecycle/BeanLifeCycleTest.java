package hello.core.lifecycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    @DisplayName("빈 생명주기 테스트")
    void LifeCycleTest() {
        //given
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        //when
        NetworkClient_Annotation client = ac.getBean(NetworkClient_Annotation.class);
        ac.close();
        //then

    }
    @Configuration
    static class LifeCycleConfig{

        // 1.인터페이스
       /* @Bean
       public NetworkClient_Interface networkClient(){
            NetworkClient_Interface networkClient = new NetworkClient_Interface();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }*/

        // 2. 빈
        /*  @Bean(initMethod = "init", destroyMethod = "close")
        // destroyMethod 메소드를 적지않아도 기본값으로 추론기능이 있기때문에 종료지원.
        // 외부 라이브러리에 적용 가능.

        public NetworkClient_Bean networkClient() {
            NetworkClient_Bean networkClient = new NetworkClient_Bean();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }*/

        // 3. 애노테이션
        // 스프링에 종속적이지 않음
        // 외부 라이브러리에 적용 못함.
        @Bean
        public NetworkClient_Annotation networkClient() {
            NetworkClient_Annotation networkClient = new NetworkClient_Annotation();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }

    }
}
