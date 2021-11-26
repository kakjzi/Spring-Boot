package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

public class StatefulServiceTest {
    @Test
    void StatefulServiceSinfgleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);

        //ThreadB: B사용자 20000원 주문
        int userBPrice = statefulService2.order("userA", 20000);

        //ThreadA: A사용자 주문 조회
        System.out.println("price = " + userAPrice);

        //assertThat(statefulService1.getPrice()).isEqualTo(20000);

        //인스턴스를 공유하기 때문에 해당 문제 발생..!!!!
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }
}
