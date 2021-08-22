package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService=ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService=ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository=ac.getBean("memberRepository",MemberRepository.class);

        MemberRepository memberRepository1= memberService.getMemberRepository();
        MemberRepository memberRepostiory2=orderService.getMemberRepository();
        
        System.out.println("memberRepostiory1 = " + memberRepository1);
        System.out.println("memberRepostiory2 = " + memberRepostiory2);
        System.out.println("memberRepository = " + memberRepository);

//        출력결과 :
//        memberRepostiory1 = hello.core.member.MemoryMemberRepository@719e7438
//        memberRepostiory2 = hello.core.member.MemoryMemberRepository@719e7438
//        memberRepository = hello.core.member.MemoryMemberRepository@719e7438
        assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);


    }

    @Test
    void configurationDeep(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean=ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());

    }

}
