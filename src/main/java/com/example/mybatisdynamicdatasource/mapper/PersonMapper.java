package com.example.mybatisdynamicdatasource.mapper;

import com.example.mybatisdynamicdatasource.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Options(keyProperty = "id", useGeneratedKeys = true, keyColumn = "id")
    @Insert("insert into ta_person (email, name, sex) values (#{email}, #{name}, #{sex})")
    int save(Person person);

    @Select("select * from ta_person")
    List<Person> list();
}
