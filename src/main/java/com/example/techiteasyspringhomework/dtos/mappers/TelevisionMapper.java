package com.example.techiteasyspringhomework.dtos.mappers;

import com.example.techiteasyspringhomework.dtos.outputDtos.TelevisionOutputDto;
import com.example.techiteasyspringhomework.dtos.inputDtos.TelevisionInputDto;
import com.example.techiteasyspringhomework.models.Television;
import com.example.techiteasyspringhomework.services.CIModuleService;

public class TelevisionMapper {



    public static Television fromInputDtoToModel(TelevisionInputDto televisionInputDto) {
        Television t = new Television();
        t.setName(televisionInputDto.getName());
        t.setBrand(televisionInputDto.getBrand());
        t.setPrice(televisionInputDto.getPrice());
        t.setOriginalStock(televisionInputDto.getOriginalStock());
        t.setSold(televisionInputDto.getSold());
        t.setType(televisionInputDto.getType());
        t.setAvailableSize(televisionInputDto.getAvailableSize());
        t.setRefreshRate(televisionInputDto.getRefreshRate());
        t.setScreenType(televisionInputDto.getScreenType());
        t.setScreenQuality(televisionInputDto.getScreenQuality());
        t.setSmartTv(televisionInputDto.isSmartTv());
        t.setWifi(televisionInputDto.isWifi());
        t.setVoiceControl(televisionInputDto.isVoiceControl());
        t.setHdr(televisionInputDto.isHdr());
        t.setBluetooth(televisionInputDto.isBluetooth());
        t.setAmbiLight(televisionInputDto.isAmbiLight());

        return t;
    }

    public static TelevisionOutputDto fromModelToDto(Television television) {
        TelevisionOutputDto televisionDto = new TelevisionOutputDto();
        televisionDto.setId(television.getId());
        televisionDto.setName(television.getName());
        televisionDto.setBrand(television.getBrand());
        televisionDto.setPrice(television.getPrice());
        televisionDto.setOriginalStock(television.getOriginalStock());
        televisionDto.setSold(television.getSold());
        televisionDto.setType(television.getType());
        televisionDto.setAvailableSize(television.getAvailableSize());
        televisionDto.setRefreshRate(television.getRefreshRate());
        televisionDto.setScreenType(television.getScreenType());
        televisionDto.setScreenQuality(television.getScreenQuality());
        televisionDto.setSmartTv(television.isSmartTv());
        televisionDto.setWifi(television.isWifi());
        televisionDto.setVoiceControl(television.isVoiceControl());
        televisionDto.setHdr(television.isHdr());
        televisionDto.setBluetooth(television.isBluetooth());
        televisionDto.setAmbiLight(television.isAmbiLight());

        if(television.getCiModule() != null) {
            televisionDto.setCiModuleOutputDto(CIModuleMapper.fromModelToDto(television.getCiModule()));
        }


        return televisionDto;
    }

}
