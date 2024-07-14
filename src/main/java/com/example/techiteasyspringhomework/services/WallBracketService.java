package com.example.techiteasyspringhomework.services;

import com.example.techiteasyspringhomework.dtos.inputDtos.WallBracketInputDto;
import com.example.techiteasyspringhomework.dtos.mappers.WallBracketMapper;
import com.example.techiteasyspringhomework.dtos.outputDtos.WallBracketOutputDto;
import com.example.techiteasyspringhomework.exceptions.RecordNotFoundException;
import com.example.techiteasyspringhomework.models.WallBracket;
import com.example.techiteasyspringhomework.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }


    public WallBracketOutputDto createWallBracket(WallBracketInputDto wallBracketInputDto) {
        WallBracket wb = wallBracketRepository.save(WallBracketMapper.fromInputDtoToModel(wallBracketInputDto));
        return WallBracketMapper.fromModelToOutputDto(wb);
    }

    public List<WallBracketOutputDto> getAllWallBrackets() {
        List<WallBracket> allWallBrackets = wallBracketRepository.findAll();
        List<WallBracketOutputDto> wallBracketDtos = new ArrayList<>();
        for (WallBracket wb : allWallBrackets) {
            wallBracketDtos.add(WallBracketMapper.fromModelToOutputDto(wb));
        } return wallBracketDtos;
    }

    public WallBracketOutputDto getWallBracketById(Long id) {
        Optional<WallBracket> wb = wallBracketRepository.findById(id);
        if (wb.isPresent()) {
            return WallBracketMapper.fromModelToOutputDto(wb.get());
        } else {
            throw new RecordNotFoundException("No wallbracket found with id: " + id);
        }
    }

    public void deleteWallBracket(Long id) {
        wallBracketRepository.deleteById(id);
    }


    public WallBracketOutputDto updateWallBracket(Long id, WallBracketInputDto updatedWallBracket) {
        Optional<WallBracket> wb = wallBracketRepository.findById(id);
        if (wb.isPresent()) {
            WallBracket wb1 = wb.get();
            wb1.setPrice(updatedWallBracket.getPrice());
            wb1.setAdjustable(updatedWallBracket.getAdjustable());
            wb1.setName(updatedWallBracket.getName());
            wb1.setSize(updatedWallBracket.getSize());

            WallBracket returnWallBracket = wallBracketRepository.save(wb1);
            return WallBracketMapper.fromModelToOutputDto(returnWallBracket);
        } else {
            throw new RecordNotFoundException("No wallbracket found with id: " + id);
        }
    }
}
