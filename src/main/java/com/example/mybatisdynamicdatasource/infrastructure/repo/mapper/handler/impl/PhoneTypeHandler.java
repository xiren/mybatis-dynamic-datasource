package com.example.mybatisdynamicdatasource.infrastructure.repo.mapper.handler.impl;

import com.example.mybatisdynamicdatasource.domain.Phone;
import com.example.mybatisdynamicdatasource.infrastructure.repo.mapper.handler.JsonTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(Phone.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class PhoneTypeHandler extends JsonTypeHandler<Phone> {

}
