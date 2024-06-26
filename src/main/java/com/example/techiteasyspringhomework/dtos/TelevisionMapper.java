package com.example.techiteasyspringhomework.dtos;

import com.example.techiteasyspringhomework.models.Television;

public class TelevisionMapper {

    public static Television fromInputDtoToModel(TelevisionInputDto televisionInputDto) {
        Television t = new Television();
        t.setName(televisionInputDto.name);
        t.setBrand(televisionInputDto.brand);
        t.setPrice(televisionInputDto.price);
        t.setOriginalStock(televisionInputDto.originalStock);
        t.setSold(televisionInputDto.sold);
        t.setType(televisionInputDto.type);
        t.setAvailableSize(televisionInputDto.availableSize);
        t.setRefreshRate(televisionInputDto.refreshRate);
        t.setScreenType(televisionInputDto.screenType);
        t.setScreenQuality(televisionInputDto.screenQuality);
        t.setSmartTv(televisionInputDto.smartTv);
        t.setWifi(televisionInputDto.wifi);
        t.setVoiceControl(televisionInputDto.voiceControl);
        t.setHdr(televisionInputDto.hdr);
        t.setBluetooth(televisionInputDto.bluetooth);
        t.setAmbiLight(televisionInputDto.ambiLight);

        return t;
    }

    public static TelevisionDto fromModelToDto(Television television) {
        TelevisionDto televisionDto = new TelevisionDto();
        televisionDto.setId(television.getId());
        televisionDto.setName(television.getName());
        televisionDto.setBrand(television.getBrand());
        televisionDto.setPrice(television.getPrice());
        televisionDto.setOriginalStock(television.getOriginalStock());
        televisionDto.setSold(television.getSold());
        televisionDto.setType(television.getType());
        televisionDto.setAvailableSize(television.getAvailableSize());
        televisionDto.setRefreshRate(televisionDto.getRefreshRate());
        televisionDto.setScreenType(televisionDto.getScreenType());
        televisionDto.setScreenQuality(televisionDto.getScreenQuality());
        televisionDto.setSmartTv(televisionDto.isSmartTv());
        televisionDto.setWifi(televisionDto.isWifi());
        televisionDto.setVoiceControl(televisionDto.isVoiceControl());
        televisionDto.setHdr(televisionDto.isHdr());
        televisionDto.setBluetooth(televisionDto.isBluetooth());
        televisionDto.setAmbiLight(televisionDto.isAmbiLight());

        return televisionDto;
    }

}
