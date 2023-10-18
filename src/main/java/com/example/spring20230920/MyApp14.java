package com.example.spring20230920;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class MyApp14 {
    public static void main(String[] args) {
        // Spring Boot 애플리케이션을 시작하는 엔트리 포인트
        ApplicationContext context = SpringApplication.run(MyApp14.class, args);
//        빈을 가져와 출력
        Object bean1 = context.getBean("myBean1");
        System.out.println("bean1 = " + bean1);

        Object bean2 = context.getBean("myBean2");
        System.out.println("bean2 = " + bean2);

        Configuration1 conf = context.getBean("configuration1", Configuration1.class);
        MyClass27 obj1 = conf.myBean1();
        MyClass27 obj2 = conf.myBean2();

        System.out.println("obj1 = " + obj1);
        System.out.println("obj2 = " + obj2);

        System.out.println(conf.myBean1());
        System.out.println(conf.myBean1());
        System.out.println(new MyClass27());
        System.out.println(new MyClass27());

        System.out.println("conf = " + conf);
    }
}

// Configuration 클래서(빈) :
// spring bean을 만드는 메소드를 가진 클래스
// @Configuration 어노테이션은 이 클래스가 Bean 구성 클래스임을 나타냅니다.
@Configuration
class Configuration1 {
    // 빈을 만드는 메소드
    // bean의 이름은 메소드명과 같음
    // @Bean 어노테이션은 해당 메소드가 Bean을 생성하는 메소드임을 나타냅니다.
    // myBean1 및 myBean2라는 두 개의 빈을 생성하는 메소드를 포함하고 있습니다.
    @Bean
    public MyClass27 myBean1() {
        return new MyClass27();
    }

    @Bean
    public MyClass27 myBean2() {
        return new MyClass27();
    }
}

// @Component // 빈의 이름이 클래스 이름을 lowerCamelCase로 바꾼 것
class MyClass27 {

}