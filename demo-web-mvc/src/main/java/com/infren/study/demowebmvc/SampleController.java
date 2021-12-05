package com.infren.study.demowebmvc;

import java.awt.PageAttributes.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.function.ServerRequest.Headers;
import org.w3c.dom.html.HTMLTableCaptionElement;

@Controller
@RequestMapping("/events")
public class SampleController {

    @ResponseBody
    @GetMapping("/{number}")
    public String event(@PathVariable String number) {
        return "events " + number;
    }

    @ResponseBody
    @PostMapping(value = "/",consumes = "application/json", produces = "application/json")
    public String eventPost() {
        return "events ";
    }

    @ResponseBody
    @DeleteMapping("/{number}")
    public String eventDelete(@PathVariable String number) {
        return "events "+ number;
    }

    @ResponseBody
    @PutMapping(value = "/{number}", produces = "application/json",consumes = "application/json")
    public String eventPut(@PathVariable String number) {
        return "events "+ number;
    }

}
