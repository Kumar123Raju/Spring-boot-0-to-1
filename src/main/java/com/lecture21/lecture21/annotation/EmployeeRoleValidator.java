package com.lecture21.lecture21.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

//step4: you have to use same structure for string if you want different then try different way.either by changing just string to specific
public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {

    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        List<String> roles= List.of("ADMIN","USER");
        return roles.contains(inputRole);
    }
}
