package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",  // 컴포넌트 스캔의 대상
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class) // @Configuration 이 붙은 것들은 제외시킨다. ( 기존에 @Configuration 을 붙여 직접만든 코드가 있기 때문에)
)
public class AutoAppConfig {
    @Bean(name="memoryMemberRepository")
    public MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }


}
