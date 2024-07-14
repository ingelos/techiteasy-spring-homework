package com.example.techiteasyspringhomework.dtos.mappers;

import com.example.techiteasyspringhomework.dtos.inputDtos.RemoteControllerInputDto;
import com.example.techiteasyspringhomework.dtos.outputDtos.RemoteControllerOutputDto;
import com.example.techiteasyspringhomework.models.RemoteController;

public class RemoteControllerMapper {

    public static RemoteController fromInputDtoToModel(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController re = new RemoteController();
        re.setCompatibleWith(remoteControllerInputDto.getCompatibleWith());
        re.setBatteryType(remoteControllerInputDto.getBatteryType());
        re.setName(remoteControllerInputDto.getName());
        re.setBrand(remoteControllerInputDto.getBrand());
        re.setPrice(remoteControllerInputDto.getPrice());
        re.setOriginalStock(remoteControllerInputDto.getOriginalStock());
        return re;
    }

    public static RemoteControllerOutputDto fromModelToOutputDto(RemoteController remoteController) {
        RemoteControllerOutputDto remoteControllerOutputDto = new RemoteControllerOutputDto();
        remoteControllerOutputDto.setId(remoteController.getId());
        remoteControllerOutputDto.setCompatibleWith(remoteController.getCompatibleWith());
        remoteControllerOutputDto.setBatteryType(remoteControllerOutputDto.getBatteryType());
        remoteControllerOutputDto.setName(remoteController.getName());
        remoteControllerOutputDto.setBrand(remoteController.getBrand());
        remoteControllerOutputDto.setPrice(remoteController.getPrice());
        remoteControllerOutputDto.setOriginalStock(remoteController.getOriginalStock());
        return remoteControllerOutputDto;

    }
}
