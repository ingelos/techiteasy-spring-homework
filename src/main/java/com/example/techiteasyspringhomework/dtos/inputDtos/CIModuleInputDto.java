package com.example.techiteasyspringhomework.dtos.inputDtos;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CIModuleInputDto {

    private String name;
    private String type;
    @Positive
    private Double price;


}
