package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    // 생성자를 통해서 구현체를 연결시키도록 코드를 고친다.  - 생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
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
