package com.example.mybatisdynamicdatasource.application.param;

import com.example.mybatisdynamicdatasource.domain.Phone;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class PersonCreateParam {
    @NotNull(message = "name should not be empty")
    private String name;
    @Email(message = "email address is invalid")
    private String email;
    @NotNull(message = "sex should not be empty")
    @Range(min = 0, max = 1, message = "sex should be 0 or 1")
    private byte sex;
    private Phone phone;
}
