package com.example.demo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS) // 이 어노테이션 정보를 어느정도 까지 유지할 것인가 기본값은 CLASS
@Target(ElementType.METHOD) // 메소드가 타겟임
@Documented
public @interface PerLogging {

}
