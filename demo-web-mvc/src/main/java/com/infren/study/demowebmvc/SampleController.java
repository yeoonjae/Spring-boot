package com.infren.study.demowebmvc;

import java.awt.PageAttributes.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @ResponseBody
    @RequestMapping(value = "/hello",consumes = "application/json",produces = "text/plain")
    public String hello() {
        return "hello";
    }

}
