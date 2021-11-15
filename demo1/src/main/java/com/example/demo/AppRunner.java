package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

//@Component
public class AppRunner implements ApplicationRunner {


    @Value("#{1+1}")
    int value;

    @Value("#{'Hello ' + ' World'}")
    String hello;

    @Value("#{1 eq 1}")
    boolean trueOrFalse;

    @Value("you are great")
    String great;

    @Value("${my.value}") // 프로퍼티 값 읽어오기
    String myName;

    @Value("#{${my.value} eq 100}") // 프로퍼티 값과의 비교 가능
    boolean isMyNameSaelobi;

    @Value("#{sample.data}") // Bean으로 등록된 객체 참조 가능
    int sampleData;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==============");
        System.out.println(value);
        System.out.println(hello);
        System.out.println(trueOrFalse);
        System.out.println(great);
        System.out.println(myName);
        System.out.println(isMyNameSaelobi);
        System.out.println(sampleData);

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("2+100");
        Integer value = expression.getValue(Integer.class);
        System.out.println(value);
    }
}
