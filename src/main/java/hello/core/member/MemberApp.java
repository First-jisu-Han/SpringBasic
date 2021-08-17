package hello.core.member;

import hello.core.AppConfig;

// 순수 java 실행하는 테스트 - spring의 annotation @Test 없이 테스트 하는 것.
public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig=new AppConfig();

        // MemberService memberService =new MemberServiceImpl(new MemoryMemberRepository()); 와 같음
        MemberService memberService= appConfig.memberService();

        Member member=new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);

        Member findMember= memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find member=" + findMember.getName());


        // 순수한 자바 코드로 연결여부 확인


    }
}
