package me.whiteship.dempspring51;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {

    @EventListener
    @Async
    public void handle(MyEvent myEvent) {
        System.out.println(Thread.currentThread().toString());
        System.out.println("Another : " + myEvent.getData());
    }

    @EventListener
    public void handle(ContextRefreshedEvent event) {   // ApplicationContext 를 초기화하거나 리프레시 했을 때 발생
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextRefreshedEvent");
    }

    @EventListener
    public void handle(ContextClosedEvent event) {  // ApplicationContext를 Close()하여 싱글톤 빈 소멸되는 시점에 발생
        System.out.println(Thread.currentThread().toString());
        System.out.println("ContextClosedEvent");
    }

}
