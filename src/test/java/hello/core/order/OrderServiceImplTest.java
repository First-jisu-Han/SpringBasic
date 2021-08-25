package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceImplTest {
//    @Test
//    void createOrder(){
//        // 여기는 스프링 없이 순수 java 코드로만 가져와서 조립을 해서 테스트 한 코드들이다. @Autowired 이용하지 않았다.
//        MemoryMemberRepository memberRepository= new MemoryMemberRepository();
//        memberRepository.save(new Member(1L,"name", Grade.VIP));
//        OrderServiceImpl orderService=new OrderServiceImpl(memberRepository,new FixDiscountPolicy());
//        Order order= orderService.createOrder(1L,"itemA",10000);
//        assertThat(order.getDiscountPrice()).isEqualTo(1000);
//    }

}
