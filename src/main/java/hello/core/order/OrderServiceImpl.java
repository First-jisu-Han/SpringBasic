package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;


//orderServiceImpl은 두가지의 객체가 필요하다 - discountPolicy와 MemberRepository의 객체
public class OrderServiceImpl implements OrderService{

    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    public OrderServiceImpl(MemberRepository memberRepository,DiscountPolicy discountPolicy){
        this.memberRepository=memberRepository;
        this.discountPolicy=discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice= discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);


    }
}
