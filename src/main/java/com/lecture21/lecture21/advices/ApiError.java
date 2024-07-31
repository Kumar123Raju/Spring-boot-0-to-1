package com.lecture21.lecture21.advices;

import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> subErrors;


}
