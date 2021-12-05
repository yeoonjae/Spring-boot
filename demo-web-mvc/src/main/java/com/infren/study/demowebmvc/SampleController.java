package com.infren.study.demowebmvc;

import java.awt.PageAttributes.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.html.HTMLTableCaptionElement;

@Controller
public class SampleController {

    @ResponseBody
    @GetHelloMapping
    public String hello() {
        return "hello";
    }
//    @PostMapping("/hello")
//    public String hello() {
//        return "hello";
//    }

}
