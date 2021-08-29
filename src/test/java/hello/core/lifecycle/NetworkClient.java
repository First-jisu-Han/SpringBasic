package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NetworkClient implements InitializingBean,DisposableBean {

   /* 스프링 빈 생명주기 콜백

    ConfigurableApplicationContext ac=new AnnotationConfigApplicationContext(LifeCycleConfig.class);  // 스프링 컨테이너 생성
    NetworkClient client=ac.getBean(NetworkClient.class);  // NetworkClient 타입을 찾아서 스프링 빈 반환, client에 저장
    ac.close();

    ac라는 스프링 컨테이너 생성(LifeCycleConfig.class에 정의된 ) ->
    client에 NetworkClient 클래스 타입의 스프링 빈을 반환하여 저장 :
    1. NetworkClient networkClient = new NetworkClient();  client에 저장하는 과정에서 생성자가 호출
    2. networkClient.setUrl("http://hello-spring.dev");    afterPropertiesSet() 에 의해 초기화 진행 connect(), call("초기화 연결 메세지")

    ac.close(); -> destroy()에 의해 메서드 소멸- 빈사용 중지됨 // disconnect();

    */
    private String url; 

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);
    }
    public void setUrl(String url){
        this.url=url;
    }

    // 서비스를 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println(" call: " + url +" message " + message);
    }

    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println(" close " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception{      //초기화를 지원하는 메서드
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }
    @Override
    public void destroy() throws Exception{               // 소멸을 지원하는 메서드
        System.out.println("NetworkClient.destroy");
        disconnect();
    }



}
