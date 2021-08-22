package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.Annotation;

public class StatefulServiceTest {

    @Test
    void statefulServiceSigleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1=ac.getBean("statefulService",StatefulService.class);
        StatefulService statefulService2=ac.getBean("statefulService",StatefulService.class);

        // ThreadA : A사용자 10000원 주문
        statefulService1.order("UserA",10000);
        // ThreadB : B사용자 20000원 주문
        statefulService2.order("UserA",20000);

        // ThreadA : 사용자A 주문금액 조회
        int price=statefulService1.getPrice();
        System.out.println("price = " + price);  // 1만원이 아니라 2만원 출력

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    // 빈 등록 하는 클래스
    static class TestConfig {
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }
}
