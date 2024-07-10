package com.lecture21.lecture21.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfigs {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
