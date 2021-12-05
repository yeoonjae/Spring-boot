package com.infren.study.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class SampleController {

    @ResponseBody
    @RequestMapping("/yeonjae")
    public String hello() {
        return "hello yeonjae";
    }

    @ResponseBody
    @RequestMapping("/**")
    public String helloYeonjae() {
        return "hello ";
    }
}
