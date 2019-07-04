package com.example.mybatisdynamicdatasource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private long id;
    private String email;
    private String name;
    private byte sex;
}
