package com.example.mybatisdynamicdatasource.domain;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidationConcern {

    protected ValidationConcern() {
        super();
    }

    protected static Validator validator = Validation.byProvider(HibernateValidator.class).
            configure().failFast(false).buildValidatorFactory().getValidator();

    public void validate() {
        Set<ConstraintViolation<ValidationConcern>> constraintViolations = this.validator.validate(this);
        String errors = constraintViolations.stream().map(c -> c.getMessage()).collect(Collectors.joining("; "));
        throw new IllegalStateException(errors);
    }
}
