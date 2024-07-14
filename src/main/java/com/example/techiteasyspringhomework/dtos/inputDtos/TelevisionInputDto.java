package com.example.techiteasyspringhomework.dtos.inputDtos;

import com.example.techiteasyspringhomework.enums.AvailableSize;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class TelevisionInputDto {

    @Size(max = 20, message = "Name must be between 0-20 characters")
    private String name;
    @NotNull(message = "Brand is required")
    private String brand;
    @Positive
    private Double price;
    @PositiveOrZero(message = " Television cannot have negative stock")
    private int originalStock;
    @Positive
    private int sold;
    @NotNull(message = "Type is required")
    private String type;
    private AvailableSize availableSize;
    private int refreshRate;
    private String screenType;
    private String screenQuality;
    private boolean smartTv;
    private boolean wifi;
    private boolean voiceControl;
    private boolean hdr;
    private boolean bluetooth;
    private boolean ambiLight;


}
