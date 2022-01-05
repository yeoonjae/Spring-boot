package me.whiteship.demospringioc.book;

import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  Map<String,Object> selectUserById(String loginId);

}

