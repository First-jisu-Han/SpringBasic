package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService=ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 (구현체) 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService=ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        // 이 테스트 메서드는 구현에 의존한 것이기 때문에 좋지는 않다.
    }
    @Test
    @DisplayName("빈 이름으로 조회 x")
    void findBeanByNameX(){
// 람다식 - 42번쩨 코드를 실행하면 41반째 코드에 있는 예외가 터져야 한다 라는 뜻.
        assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxxx",MemberService.class));
    }
}
