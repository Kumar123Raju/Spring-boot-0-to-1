package com.lecture21.lecture21.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//Do same step for anny annotation
//step1: you have to put these 3 annoation according to this same to same
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
//step 3: you should define logi inside employeeRoleValidator class
@Constraint(validatedBy = {EmployeeRoleValidator.class})
public @interface EmployeeRoleValidation {
//    step2: you have to also copy paste these 3 bellow from any build annotaion
    String message() default "Only Either Admin allowed or User Allowed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
