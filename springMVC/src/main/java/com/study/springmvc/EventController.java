package com.study.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    // get 요청으로 events 요청이 들어오면 처리하는 핸들러를 가르킴
    // @RequestMapping(value = "/events", method = RequestMethod.GET)
    @GetMapping("/events") // 메타 어노테이션을 사용한 어노테이션
    public String events(Model model) {
        model.addAttribute("events",eventService.getEvents());
        return "events";
    }
}
