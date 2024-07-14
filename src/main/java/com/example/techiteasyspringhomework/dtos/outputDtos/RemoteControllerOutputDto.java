package com.example.techiteasyspringhomework.dtos.outputDtos;

import lombok.Data;

@Data
public class RemoteControllerOutputDto {

    private Long id;
    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;


}
