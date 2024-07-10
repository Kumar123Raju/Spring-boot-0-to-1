package com.lecture21.lecture21.service;

import com.lecture21.lecture21.dto.EmployeDto;
import com.lecture21.lecture21.entities.EmployeEntities;
import com.lecture21.lecture21.repositories.EmployeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

//    if you are not declare private final then you can use field injectin other wise if you use final
//    then compusory you have to use Contructor injection

    @Autowired
    private  EmployeRepository employeRepository;
    @Autowired
    private ModelMapper modelMapper;


    public EmployeDto getEmployee(Integer id){

         EmployeEntities employeEntities=employeRepository.findById(id).orElse(null);
         return modelMapper.map(employeEntities,EmployeDto.class);
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





}
