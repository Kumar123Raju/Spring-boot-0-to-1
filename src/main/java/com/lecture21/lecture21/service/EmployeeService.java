package com.lecture21.lecture21.service;

import com.lecture21.lecture21.dto.EmployeDto;
import com.lecture21.lecture21.entities.EmployeEntities;
import com.lecture21.lecture21.exceptions.ResourceNotFoundException;
import com.lecture21.lecture21.repositories.EmployeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Field;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

//    if you are not declare private final then you can use field injectin other wise if you use final
//    then compusory you have to use Contructor injection

    @Autowired
    private  EmployeRepository employeRepository;
    @Autowired
    private ModelMapper modelMapper;




    public boolean isExistByEmployeId(Integer employeeId){
        return employeRepository.existsById(employeeId);
    }

    public Optional<EmployeDto> getEmployee(Integer id){
//        boolean isExist=employeRepository.existsById(id);
//        if(!isExist) return null;
//        return modelMapper.map(employeRepository.findById(id),EmployeDto.class);
        return employeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeDto.class));


    }

    public EmployeDto setEmployee(EmployeDto emp) {
        EmployeEntities saveit=modelMapper.map(emp,EmployeEntities.class);
        EmployeEntities savedEmployee=employeRepository.save(saveit);
        return modelMapper.map(savedEmployee,EmployeDto.class);
    }

    public List<EmployeDto> getAllEmployee() {
        List<EmployeEntities> employeEntitiesList=employeRepository.findAll();

        if (employeEntitiesList.isEmpty()) {
            return Collections.emptyList(); // Return empty list if database is empty
        }


        return employeEntitiesList
                .stream()
                .map(employeEntities1->modelMapper.map(employeEntities1,EmployeDto.class))
                .collect(Collectors.toList());
    }


    public EmployeDto updateEmployee(EmployeDto emp,Integer id) {
        boolean isExist=isExistByEmployeId(id);
        if(!isExist) throw new ResourceNotFoundException("Employee not found with id: "+id);
         EmployeEntities employeEntities=modelMapper.map(emp,EmployeEntities.class);
         employeEntities.setId(id);
         EmployeEntities updatedEmployees=employeRepository.save(employeEntities);
         return modelMapper.map(updatedEmployees,EmployeDto.class);

    }

    public Boolean  deleteEmployee(Integer id) {
        EmployeEntities employeEntities=employeRepository.findById(id).orElse(null);
        if(employeEntities==null) throw new ResourceNotFoundException("Employee not found with id: "+id);
        employeRepository.deleteById(id);
        return true;
    }

    public EmployeDto updatePartialEmployee(Map<String, Object> updates, Integer id) {
        boolean isExist=isExistByEmployeId(id);
        if(!isExist) return null;
        EmployeEntities employeEntities=employeRepository.findById(id).get();

        updates.forEach((key,value)->{
            Field fieldToBeUpdated=ReflectionUtils.findRequiredField(EmployeEntities.class,key);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,employeEntities,value);
        });
        return modelMapper.map(employeRepository.save(employeEntities),EmployeDto.class);

    }
}
