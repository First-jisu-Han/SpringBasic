package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig=new AppConfig();
//        MemberService memberService= appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService",MemberService.class);
        // 스프링 전환 -> AppConfig클래스에서 @Bean을 찾는데, 이름은 메서드 이름 기준으로 찾는다. name은 memberService이고 오른쪽은 타입이다.

        Member member=new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);

        Member findMember= memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find member=" + findMember.getName());


        // 순수한 자바 코드로 연결여부 확인


    }
}
