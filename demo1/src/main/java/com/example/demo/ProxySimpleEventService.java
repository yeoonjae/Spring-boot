package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary // 같은 타입의 빈이 여러가지 일 때 그 중 하나를 선택하는 어노테이션
@Service
public class ProxySimpleEventService implements EventService {

    // Proxy의 경우 Subject의 빈을 주입받아서 사용해야합니다.
    // EventService로 등록을 해도 되지만 변수명을 Subject 명으로 사용해야 합니다.
    @Autowired
    SimpleEventService simpleEventService;

    @Override
    public void createEvent() {
        long begin = System.currentTimeMillis();
        simpleEventService.createEvent();
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void publishEvent() {
        long begin = System.currentTimeMillis();
        simpleEventService.publishEvent();
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void deleteEvent() {
        simpleEventService.deleteEvent();
    }
}
