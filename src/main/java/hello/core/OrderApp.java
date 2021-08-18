package hello.core;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 테스트 케이스 없이 그냥 실행한 것.

public class OrderApp {


    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService= applicationContext.getBean("orderService",OrderService.class);


        Long memberId=1L;
        Member member= new Member(memberId,"memberA", Grade.VIP );
        memberService.join(member);

        Order order= orderService.createOrder(memberId,"itemA",20000);

        System.out.println("order="+ order);
        System.out.println("order.calculatePrice =" + order.calculatePrice());
    }



}
