package com.example.mybatisdynamicdatasource.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Phone {
    private String brand;
    private String system;
}
