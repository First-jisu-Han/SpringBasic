package hello.core.singleton;

import org.junit.jupiter.api.Test;

public class SingletonService {

    // private final 을 통해서 객체를 하나만 생성하도록한다.
    private static final SingletonService instance = new SingletonService();

    // 객체 생성의 유일한 방법
    public static SingletonService getInstance(){
        return instance;
    }

    // 생성자를 private 으로 설정하여 외부에서 객체를 생성하지 못하도록한다.
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }




}
