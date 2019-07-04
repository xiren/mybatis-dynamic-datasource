package com.example.mybatisdynamicdatasource.mapper;

import com.example.mybatisdynamicdatasource.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Insert("insert into ta_person (email, name, sex) values (#{email}, #{name}, #{sex})")
    @SelectKey(statement = "select last_insert_id() as id", keyProperty = "id", before = false, resultType = Long.class)
    void save(Person person);

    @Select("select * from ta_person")
    List<Person> list();
}
