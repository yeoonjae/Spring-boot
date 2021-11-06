package me.whiteship.dempspring51;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

// Spring 4.2부터는 ApplicationListener<MyEvent> 구현을 생략할 수 있다.
@Component
public class MyEventHandler{

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE) // 순서를 지정하는 어노테이션 (나중에 찍고싶다면 Ordered.HIGHEST_PRECEDENCE +2)를 해주면 된다. 
    @Async // 비동기적으로 실행하고 싶을 때 사용
    public void handle(MyEvent event) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("이벤트를 받았다. 데이터는 " + event.getData());
    }
}
