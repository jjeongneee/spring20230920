package com.example.spring20230920;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class MyApp16 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp16.class, args);

        // ApplicationContext로부터 빈을 가져옴
        MyClass31 bean1 = context.getBean("myClass31Bean", MyClass31.class);
        MyClass30 bean2 = context.getBean("myClass30Bean", MyClass30.class);

        // 빈의 해시 코드를 출력
        System.out.println("bean2 = " + bean2.hashCode()); // int
        System.out.println("bean1 = " + bean1.hashCode()); // int (1)

        // bean2의 필드에 접근하고 해당 필드의 해시 코드를 출력
        System.out.println(bean2.getField().hashCode()); // int (1)

        // (1)로 표시한 값은 같은 값이 나오도록...
        // Configuration Spring Bean, configuration3 작성
        // MyClass30, MyClass31에 annotation 작성 하지 않기
        // 필요하면 생성자나 setter 작성 가능

    }
}
@Configuration
class Configuration3 {
    @Bean
    public MyClass31 myClass31Bean() {
        return new MyClass31();
    }

    @Bean
    public MyClass30 myClass30Bean() {
        return new MyClass30(myClass31Bean());
    }
}

class MyClass31 {

}
class MyClass30 {
    private MyClass31 field;

    public MyClass30(MyClass31 field) {
        this.field = field;
    }

    public MyClass31 getField() {
        return field;
    }
}