package com.lecture21.lecture21.controller;

import com.lecture21.lecture21.dto.EmployeDto;
import com.lecture21.lecture21.entities.EmployeEntities;
import com.lecture21.lecture21.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeController {

//    i am using private final thats why used contructor injection
    private final EmployeeService employeeService;


    public EmployeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getEmployees/{id}")
    public EmployeDto getEmployee(@PathVariable Integer id) {
       return employeeService.getEmployee(id);

    }
    @GetMapping("/getAllEmployees")
    public List<EmployeDto> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @PostMapping("/setEmployees")
    public EmployeDto setEmployees(@RequestBody EmployeDto emp){
         return employeeService.setEmployee(emp);
    }




}
