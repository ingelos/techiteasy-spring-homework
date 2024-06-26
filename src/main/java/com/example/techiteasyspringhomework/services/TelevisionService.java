package com.example.techiteasyspringhomework.services;

import com.example.techiteasyspringhomework.dtos.TelevisionDto;
import com.example.techiteasyspringhomework.dtos.TelevisionInputDto;
import com.example.techiteasyspringhomework.dtos.TelevisionMapper;
import com.example.techiteasyspringhomework.exceptions.RecordNotFoundException;
import com.example.techiteasyspringhomework.models.Television;
import com.example.techiteasyspringhomework.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public TelevisionDto createTelevision(TelevisionInputDto televisionInputDto) {
        Television t = televisionRepository.save(TelevisionMapper.fromInputDtoToModel(televisionInputDto));
            return TelevisionMapper.fromModelToDto(t);
    }

    public List<TelevisionDto> getAllTelevisions() {
        List<Television> allTelevisions = televisionRepository.findAll();
        List<TelevisionDto> televisionDtos = new ArrayList<>();
        for (Television t : allTelevisions) {
            televisionDtos.add(TelevisionMapper.fromModelToDto(t));
        }
        return televisionDtos;
    }

    public TelevisionDto getTelevisionById(Long id) {
        Optional<Television> t = televisionRepository.findById(id);
        if (t.isPresent()) {
            return TelevisionMapper.fromModelToDto(t.get());
        } else {
            throw new RecordNotFoundException(("No television found with id: " + id));
        }
    }

    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }

    public TelevisionDto updateTelevision(Long id, TelevisionInputDto updatedTelevision) {
        Optional<Television> t = televisionRepository.findById(id);
        if (t.isPresent()) {

            Television television1 = t.get();
            television1.setName(updatedTelevision.getName());
            television1.setBrand(updatedTelevision.getBrand());
            television1.setPrice(updatedTelevision.getPrice());
            television1.setOriginalStock(updatedTelevision.getOriginalStock());
            television1.setSold(updatedTelevision.getSold());
            television1.setType(updatedTelevision.getType());
            television1.setAvailableSize(updatedTelevision.getAvailableSize());
            television1.setRefreshRate(updatedTelevision.getRefreshRate());
            television1.setScreenType(updatedTelevision.getScreenType());
            television1.setScreenQuality(updatedTelevision.getScreenQuality());
            television1.setSmartTv(updatedTelevision.isSmartTv());
            television1.setWifi(updatedTelevision.isWifi());
            television1.setVoiceControl(updatedTelevision.isVoiceControl());
            television1.setHdr(updatedTelevision.isHdr());
            television1.setBluetooth(updatedTelevision.isBluetooth());
            television1.setAmbiLight(updatedTelevision.isAmbiLight());

            Television returnTelevision = televisionRepository.save(television1);
            return TelevisionMapper.fromModelToDto(returnTelevision);
        }
        else {
            throw new RecordNotFoundException("Geen televisie gevonden met id: " + id);
        }
    }

}
