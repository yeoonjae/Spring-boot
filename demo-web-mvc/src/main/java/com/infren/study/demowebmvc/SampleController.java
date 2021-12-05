package com.infren.study.demowebmvc;

import java.time.ZoneId;
import java.util.TimeZone;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @ResponseBody
    @PostMapping("/events")
    public Event event(@RequestParam String name) {
        Event event = new Event();
        event.setName(name);
        return event;
    }

}
