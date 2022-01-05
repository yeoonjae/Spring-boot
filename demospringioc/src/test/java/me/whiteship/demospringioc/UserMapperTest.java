package me.whiteship.demospringioc;

import java.util.Map;
import me.whiteship.demospringioc.book.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class UserMapperTest {

  @Autowired
  UserMapper userMapper;

  @Test
  @DisplayName("아이디로 사용자 조회 테스트")
  public void selectUserByIdTest() {
    // Given
    String id = "test1";
    System.out.println(System.getenv()); // or whatever

    // When
    Map<String, Object> user = userMapper.selectUserById(id);

    // Then
    System.out.println(user);
  }
}
