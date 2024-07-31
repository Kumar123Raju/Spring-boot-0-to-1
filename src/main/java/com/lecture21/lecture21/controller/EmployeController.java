package com.lecture21.lecture21.controller;

import com.lecture21.lecture21.dto.EmployeDto;
import com.lecture21.lecture21.entities.EmployeEntities;
import com.lecture21.lecture21.exceptions.ResourceNotFoundException;
import com.lecture21.lecture21.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeController {

//    i am using private final thats why used contructor injection
    private final EmployeeService employeeService;


    public EmployeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getEmployees/{id}")
    public ResponseEntity<EmployeDto> getEmployee(@PathVariable Integer id) {
//       EmployeDto employeDto= employeeService.getEmployee(id);
//       if(employeDto==null) return ResponseEntity.notFound().build();
//       return ResponseEntity.ok(employeDto);
        Optional<EmployeDto> employeDto= employeeService.getEmployee(id);
        return employeDto
                .map(employeDto1 -> ResponseEntity.ok(employeDto1))
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id: "+id));

    }




    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<EmployeDto>> getAllEmployees(){
        List<EmployeDto> employeDtos= employeeService.getAllEmployee();
        return ResponseEntity.ok(employeDtos);
    }

    @PostMapping("/setEmployees")
    public ResponseEntity<EmployeDto> setEmployees(@RequestBody @Validated EmployeDto emp){
        EmployeDto employeDto= employeeService.setEmployee(emp);
        return new ResponseEntity<>(employeDto, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployees/{id}")
    public ResponseEntity<EmployeDto> updateEmployees(@RequestBody EmployeDto emp,@PathVariable Integer id){
        EmployeDto updatedEmployee= employeeService.updateEmployee(emp,id);
        return new ResponseEntity<>(updatedEmployee,HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEmployees/{id}")
    public ResponseEntity<String> deleteEmployees(@PathVariable Integer id){
        Boolean deletedEmployee= employeeService.deleteEmployee(id);
        if(!deletedEmployee) return new ResponseEntity<>("Given id not found",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);

    }

    @PatchMapping("/updatePartialEmployees/{id}")
    public ResponseEntity<EmployeDto> updatePartialEmployees(@RequestBody Map<String,Object> updates,
                                             @PathVariable Integer id)
    {
        EmployeDto updatedPartiallyEmployee=employeeService.updatePartialEmployee(updates,id);
        if(updatedPartiallyEmployee==null) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(updatedPartiallyEmployee,HttpStatus.OK);

    }

}
