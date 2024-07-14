package com.example.techiteasyspringhomework.dtos.outputDtos;

import com.example.techiteasyspringhomework.enums.AvailableSize;
import lombok.Data;

@Data
public class TelevisionOutputDto {


    private Long id;
    private String name;
    private String brand;
    private Double price;
    private int originalStock;
    private int sold;
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

    private CIModuleOutputDto ciModuleOutputDto;


}
