package com.example.petshop.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
public class ErrorBody {
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private List<String> message;
    private String path;
}