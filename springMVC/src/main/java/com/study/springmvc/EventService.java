package com.study.springmvc;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    public List<Event> getEvents() {
        Event event1 = Event.builder()
            .name("Spring 웹 MVC 스터디 1차")
            .limitOfEnrollment(5)
            .startDateTime(LocalDateTime.of(2021,11,21,10,0))
            .endDateTime(LocalDateTime.of(2021,11,21,18,0))
            .build();

        Event event2 = Event.builder()
            .name("Spring 웹 MVC 스터디 2차")
            .limitOfEnrollment(5)
            .startDateTime(LocalDateTime.of(2021,11,28,10,0))
            .endDateTime(LocalDateTime.of(2021,11,28,18,0))
            .build();

        return List.of(event1, event2);
    }
}
