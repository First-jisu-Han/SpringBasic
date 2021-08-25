package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter   // getter 와 setter 를 annotation processing으로  자동으로 만들어 준다.
@ToString  // toString도 만들어준다.
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok=new HelloLombok();
        helloLombok.setName("asdfas");

        String name=helloLombok.getName();
        System.out.println("name = " + name);
    }

}
