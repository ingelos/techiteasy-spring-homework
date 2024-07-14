package com.example.techiteasyspringhomework.dtos.inputDtos;

import lombok.Data;

@Data
public class RemoteControllerInputDto {

    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;


}
