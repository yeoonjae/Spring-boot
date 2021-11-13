package me.whiteship.dempspring51;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @GetMapping("/event/{event}")
    public String getEvent(@PathVariable Event event) {
        // @PathVariable : 요청 URL 패턴에 있는 일부 값을 맵핑 (@PathVariable)하는 것
        System.out.println(event);
        return event.getId().toString();
    }
}
