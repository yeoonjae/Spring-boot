package com.infren.study.demowebmvc;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(assignableTypes = {EventController.class, EventApi.class})
public class BaseController {
    @ExceptionHandler({EventException.class, RuntimeException.class})
    public String eventErrorHandler(RuntimeException exception, Model model) {
        model.addAttribute("message", "event,runtime error");
        return "error";
    }

    @InitBinder
    public void initEventBinder (WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
        webDataBinder.setValidator(new EventValidator());
    }

    @ModelAttribute
    public void categories(Model model) {
        model.addAttribute("categories", List.of("study", "hobby", "seminar"));
    }

    @ModelAttribute("categories")
    public List<String> categories2(Model model) {
        return List.of("study", "hobby", "seminar");
    }
}
