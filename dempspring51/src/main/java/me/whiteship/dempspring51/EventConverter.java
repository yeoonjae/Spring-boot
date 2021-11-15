package me.whiteship.dempspring51;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class EventConverter {

    @Component // 상태정보가 없기 떄문에 Bean으로 등록되어도 상관없다.
    // converter는 소스와 타겟 두개의 인자를 받는다 이 클래스의 경우 String타입을 소스로 받아 Event 타입으로 변환시키는 것이다.
    public static class StringToEventConverter implements Converter<String, Event> {

        @Override
        public Event convert(String source) {
            // 소스(String)을 받아서 Event로 변환하면 된다.
            return new Event(Integer.parseInt(source));
        }

    }

    // converter는 소스와 타겟 두개의 인자를 받는다 이 클래스의 경우 Event 타입을 소스로 받아 String 타입으로 변환시키는 것이다.
    public static class StringToStringConverter implements Converter<Event, String> {

        @Override
        public String convert(Event source) {
            return source.getId().toString();
        }

    }
}
