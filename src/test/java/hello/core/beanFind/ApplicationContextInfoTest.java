package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("에플리케이션 빈 출력해보기")
    void findAll(){
        // 스프링 컨테이너안의 빈 이름들을 모두 가져와서 배열안에 저장
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition=ac.getBeanDefinition(beanDefinitionName);

            // if 해당 빈의 역할이 ROLE_APPLICATION 이라면 -> 현재 네개의 APPLICATION 빈 역할을 하는 빈 객체만을 출력하도록 한 조건
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION ) {

                // 실제빈을 가져온다. Object타입인 이유는 객체의 타입을 정하지 않았기 때문에
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name=" +beanDefinitionName+" object = " + bean);
            }
        }
    }

}
