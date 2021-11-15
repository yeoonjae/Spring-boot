package me.whiteship.dempspring51;

import me.whiteship.dempspring51.EventConverter.StringToEventConverter;
import me.whiteship.dempspring51.EventConverter.StringToStringConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new StringToEventConverter()); // Converter 등록방법
        registry.addFormatter(new EventFormatter());
    }
}
