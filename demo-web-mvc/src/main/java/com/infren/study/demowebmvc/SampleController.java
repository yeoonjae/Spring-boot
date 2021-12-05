package com.infren.study.demowebmvc;

import java.time.ZoneId;
import java.util.TimeZone;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @ResponseBody
    @GetMapping("/events/{id}")
    public Event event(@PathVariable Integer id, @MatrixVariable String name) {
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        return event;
    }

}
