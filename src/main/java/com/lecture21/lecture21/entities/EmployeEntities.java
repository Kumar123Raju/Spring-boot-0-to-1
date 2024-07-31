package com.lecture21.lecture21.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employe_table")
public class EmployeEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String rollno;
    String name;
    Integer age;
    String collegeName;
    String location;
    String email;
    String role;
//    double salary;

    public void setId(Integer id) {
    }
}
