package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.*;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA=ac.getBean("beanA",BeanA.class); //beanA는 스프링 빈으로 등록 되어있다. 하지만 beanB 같은 경우는 스프링 빈으로 등록되어있지 않다.

        assertThat(beanA).isNotNull();


        org.junit.jupiter.api.Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("beanB",BeanB.class)
        );
    }


    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            // @MyIncludeComponent 어노테이션 붙은 것은 허용
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
            // @MyExcludeComponent 어노테이션 붙은 것은 제외
    )
    static class ComponentFilterAppConfig {


    }
}
