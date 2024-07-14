package com.example.techiteasyspringhomework.dtos.mappers;

import com.example.techiteasyspringhomework.dtos.inputDtos.WallBracketInputDto;
import com.example.techiteasyspringhomework.dtos.outputDtos.WallBracketOutputDto;
import com.example.techiteasyspringhomework.models.WallBracket;

public class WallBracketMapper {

    public static WallBracket fromInputDtoToModel(WallBracketInputDto wallBracketInputDto) {
        WallBracket wb = new WallBracket();
        wb.setSize(wallBracketInputDto.getSize());
        wb.setAdjustable(wallBracketInputDto.getAdjustable());
        wb.setName(wallBracketInputDto.getName());
        wb.setPrice(wallBracketInputDto.getPrice());
        return wb;
    }

    public static WallBracketOutputDto fromModelToOutputDto (WallBracket wallBracket) {
        WallBracketOutputDto wallDto = new WallBracketOutputDto();
        wallDto.setId(wallBracket.getId());
        wallDto.setAdjustable(wallBracket.getAdjustable());
        wallDto.setSize(wallBracket.getSize());
        wallDto.setName(wallBracket.getName());
        wallDto.setPrice(wallBracket.getPrice());
        return wallDto;
    }
}
