package com.example.techiteasyspringhomework.dtos.mappers;

import com.example.techiteasyspringhomework.dtos.inputDtos.CIModuleInputDto;
import com.example.techiteasyspringhomework.dtos.outputDtos.CIModuleOutputDto;
import com.example.techiteasyspringhomework.models.CIModule;

public class CIModuleMapper {

    public static CIModule fromInputDtoToModel(CIModuleInputDto ciModuleInputDto) {
        CIModule ci = new CIModule();
        ci.setName(ciModuleInputDto.getName());
        ci.setType(ciModuleInputDto.getType());
        ci.setPrice(ciModuleInputDto.getPrice());
        return ci;
    }

    public static CIModuleOutputDto fromModelToDto(CIModule ciModule) {
        CIModuleOutputDto ciModuleOutputDto = new CIModuleOutputDto();
        ciModuleOutputDto.setId(ciModule.getId());
        ciModuleOutputDto.setName(ciModule.getName());
        ciModuleOutputDto.setPrice(ciModule.getPrice());
        ciModuleOutputDto.setType(ciModule.getType());
        return ciModuleOutputDto;
    }

}
