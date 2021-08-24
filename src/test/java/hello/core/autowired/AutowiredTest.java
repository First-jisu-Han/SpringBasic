package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void autowiredOption(){
        ApplicationContext ac =new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {           // 자동주입 대상이 없다면 수정자 메서드 자체가 호출이 안된다.
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){    // 자동주입 대상이 없다면 null 반환.
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){  // 자동 주입할 대상이 없으면 Optional.empty가 입력된다.
            System.out.println("noBean3 = " + noBean3);
        }

    }

}
