package com.example.mybatisdynamicdatasource.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Person extends ValidationConcern {

    private long id;
    @Email(message = "email address is invalid")
    private String email;
    @NotNull(message = "name should not be empty")
    private String name;
    @NotNull(message = "sex should not be empty")
    @Range(min = 0, max = 1, message = "sex should be 0 or 1")
    private byte sex;
    private Phone phone;
}
