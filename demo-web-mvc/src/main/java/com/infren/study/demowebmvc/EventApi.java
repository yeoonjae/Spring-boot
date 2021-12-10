package com.infren.study.demowebmvc;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventApi {

    @ExceptionHandler
    public ResponseEntity errorHandler() {
        return ResponseEntity.badRequest().body("can't create event as ... ");
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody @Valid Event event,
        BindingResult bindingResult) {
        // save event
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }

//    @PostMapping
//    public Event createEvent2(HttpEntity<Event> request) {
//        // save event
//        MediaType contentType = request.getHeaders().getContentType();
//        System.out.println(contentType);
//        return request.getBody();
//    }
}
