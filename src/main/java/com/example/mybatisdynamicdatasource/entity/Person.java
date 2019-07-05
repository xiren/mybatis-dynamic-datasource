package com.example.mybatisdynamicdatasource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Person {

    private long id;
    private String email;
    private String name;
    private byte sex;
}
