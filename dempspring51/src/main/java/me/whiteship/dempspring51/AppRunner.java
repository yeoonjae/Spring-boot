package me.whiteship.dempspring51;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    Validator validator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(validator.getClass());

        Event event = new Event();
        event.setLimit(-1); // 에러생성
        event.setEmail("aaaa3344");

        Errors errors = new BeanPropertyBindingResult(event, "event");

        validator.validate(event,errors);

        System.out.println(errors.hasErrors());
        // 모든 에러를 가져온 뒤(getAllErrors), 순차적으로 순회를 하며 에러를 찍는다.
        errors.getAllErrors().forEach(e -> {
            System.out.println("========= error code =========");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });

//
//        Event event = new Event(); // 1. 이벤트 생성
//        EventValidator eventValidator = new EventValidator(); // 2. 이벤트 Validator 생성
//        // BeanPropertyBindingResult : 명시한 클래스에서 발생하는 오류를 저장하는 역할만 하는 객체
//        Errors errors = new BeanPropertyBindingResult(event, "event"); // 3. 에러 생성
//
//        eventValidator.validate(event, errors); // 4.validate 를 진행한다.
//
//        System.out.println(errors.hasErrors()); // 에러가 발생했는지 확인
//
//        // 모든 에러를 가져온 뒤(getAllErrors), 순차적으로 순회를 하며 에러를 찍는다.
//        errors.getAllErrors().forEach(e -> {
//            System.out.println("========= error code =========");
//            Arrays.stream(e.getCodes()).forEach(System.out::println);
//            System.out.println(e.getDefaultMessage());
//        });
    }
}
