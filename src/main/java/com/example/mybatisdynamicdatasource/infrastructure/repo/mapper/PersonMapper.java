package com.example.mybatisdynamicdatasource.infrastructure.repo.mapper;

import com.example.mybatisdynamicdatasource.domain.Person;
import com.example.mybatisdynamicdatasource.infrastructure.repo.mapper.handler.impl.PhoneTypeHandler;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into ta_person (email, name, sex, phone) values (#{email}, #{name}, #{sex}, #{phone})")
    int save(Person person);

    @Select("select id, email, name, sex, phone from ta_person")
    @Results(
            @Result(column = "phone", property = "phone", typeHandler = PhoneTypeHandler.class)
    )
    List<Person> list();
}
