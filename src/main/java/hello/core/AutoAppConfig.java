package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",  // 컴포넌트 스캔의 대상
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class) // @Configuration 이 붙은 것들은 제외시킨다. ( 기존에 @Configuration 을 붙여 직접만든 코드가 있기 때문에)
)
public class AutoAppConfig {}