package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//orderServ iceImpl은 두가지의 객체가 필요하다 - discountPolicy와 MemberRepository의 객체
@Component
//@RequiredArgsConstructor  // 롬복 라이브러리의 어노테이션이다.
public class OrderServiceImpl implements OrderService {

    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;  // final로 된 것들로 생성자자를 만들어준다 -롬복

    /* 롬복 라이브러리를 통해 @RequiredArgsConstructor 어노테이션으로 아래와 같은 생성자를 자동으로 만들어낸다.
    */
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {  // @Qualifier를 통해 빈 중에 선택가능하다.
          this.memberRepository = memberRepository;
          this.discountPolicy = discountPolicy;  }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }

    // 테스트 할 용도 - @Configuration 을통한 싱글톤 유지 확인 테스트
    public MemberRepository getMemberRepository() {
        return memberRepository;

    }


}
