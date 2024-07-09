package com.lecture21.lecture21.service;

import com.lecture21.lecture21.dto.EmployeDto;
import com.lecture21.lecture21.entities.EmployeEntities;
import com.lecture21.lecture21.repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

//    if you are not declare private final then you can use field injectin other wise if you use final
//    then compusory you have to use Contructor injection

    @Autowired
    private  EmployeRepository employeRepository;


    public EmployeEntities getEmployee(Integer id){

        return employeRepository.findById(id).orElse(null);
    }

    public EmployeEntities setEmployee(EmployeEntities emp) {
        return employeRepository.save(emp);
    }
}
