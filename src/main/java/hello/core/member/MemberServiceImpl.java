package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{



    private MemberRepository memberRepository;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }


    // 생성자를 통해서 구현체를 연결시키도록 코드를 고친다.  - 생성자 주입

    @Autowired  // 생성자에 붙이면, MemberRepository 타압에 맞는 것을 찾아와 자동 의존관계 주입 역할.
    // ac.getBean(MemberRepository.class) 와 같은 역할 
    public MemberServiceImpl(MemberRepository memberRepository) {
        System.out.println("memberRepository생성자  = " + memberRepository);
        this.memberRepository= memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }


    @Override
    public Member findMember(Long memberId) {

        return memberRepository.findById(memberId);
    }

    // 테스트 할 용도 - @Configuration 을통한 싱글톤 유지 확인 테스트
    public MemberRepository getMemberRepository() {
        return memberRepository;

    }


}
