package study.springboot.demobootweb;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.StringWriter;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ObjectMapper objectMapper; // Jackson이 제공하는 것으로 json으로 변환해줍니다.

    @Autowired
    Jaxb2Marshaller jaxb2Marshaller;


    @Test
    public void hello() throws Exception {
        Person person = new Person();
        person.setName("yeonjae");
        Person savePerson1 = personRepository.save(person);

        this.mockMvc.perform(get("/hello")
                .param("id", savePerson1.getId().toString()))
            .andDo(print())
            .andExpect(content().string("hello yeonjae"));
    }

    @Test
    public void helloStatic() throws Exception {
        this.mockMvc.perform(get("/mobile/index.html"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(Matchers.containsString("Hello Mobile")))
            .andExpect(header().exists(HttpHeaders.CACHE_CONTROL));
    }

    @Test
    public void stringMessage() throws Exception {
        this.mockMvc.perform(get("/message")
                .content("hello"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("hello"));

    }

    @Test
    public void jsonMessage() throws Exception {
        Person person = new Person();
        person.setId(2021l);
        person.setName("yeonjae");
        String jsonString = objectMapper.writeValueAsString(person);

        this.mockMvc.perform(get("/jsonMessage")
                .contentType(MediaType.APPLICATION_JSON) // 요청을 보낼 데이터 타입을 지정
                .accept(MediaType.APPLICATION_JSON) // 응답에 대한 요청으로 원하는 데이터 타입을 지정
                .content(jsonString))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(2021))
            .andExpect(jsonPath("$.name").value("yeonjae"));
    }

    @Test
    public void xmlMessage() throws Exception {
        Person person = new Person();
        person.setId(2021l);
        person.setName("yeonjae");

        StringWriter stringWriter = new StringWriter();
        Result result = new StreamResult(stringWriter);
        jaxb2Marshaller.marshal(person,result);
        String xmlString = stringWriter.toString();


        this.mockMvc.perform(get("/jsonMessage")
                .contentType(MediaType.APPLICATION_XML) // 요청을 보낼 데이터 타입을 지정
                .accept(MediaType.APPLICATION_XML) // 응답에 대한 요청으로 원하는 데이터 타입을 지정
                .content(xmlString))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(xpath("person/name").string("yeonjae"))
            .andExpect(xpath("person/id").string("2021"));
    }
}