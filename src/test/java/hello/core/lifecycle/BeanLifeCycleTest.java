package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac=new AnnotationConfigApplicationContext(LifeCycleConfig.class);  // 스프링 컨테이너 생성
        NetworkClient client=ac.getBean(NetworkClient.class);  // NetworkClient 타입을 찾아서 스프링 빈 반환, client에 저장
        ac.close(); // 스프링 컨테이너 닫으라는 뜻.
    }

    // 스프링 컨테이너 등록시키는 클래스
    @Configuration
    static class LifeCycleConfig{
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev"); // 외부에서 수정자 주입
            return networkClient;
        }
    }
}
