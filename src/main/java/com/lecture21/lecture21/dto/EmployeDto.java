package com.lecture21.lecture21.dto;


import com.lecture21.lecture21.annotation.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDto {

    Integer id;
    @NotBlank(message = "Roll number not be Blanks")
    @Size(min=3,max=20,message = "Roll number length is between 3 and 20 only")
    String rollno;
    String name;
    @Max(value=30,message = "Age of student cannot greater than 30")
    @Min(value=18 ,message="Age of student cannot smaller than 18")
    Integer age;
    String collegeName;
    @NotBlank
//    @Pattern(regexp ="^(ADMIN|USER)$",message = "Only either ADMIN or either USER")
    @EmployeeRoleValidation   //use interface name that used while making your interface
    String role;   //ADMIN,USER
    String location;
    @Email(message = "Email is Invalid")
    String email;
    @Max(value = 50000,message = "Salary is not more than 50K")
    @NotNull
    @Positive
    @Digits(integer = 6,fraction = 2,message="Salary is allowed only in This formate: xxxxxx.yy")
    double salary;


}
