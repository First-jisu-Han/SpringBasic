package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//orderServiceImpl은 두가지의 객체가 필요하다 - discountPolicy와 MemberRepository의 객체
@Component
public class OrderServiceImpl implements OrderService {



    private DiscountPolicy discountPolicy;
    private MemberRepository memberRepository;

//    @Autowired   // 생성자 위에 @Autowired 어노테이션을 통해 자동 의존관계 주입.
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


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
