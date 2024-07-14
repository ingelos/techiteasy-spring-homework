package com.example.techiteasyspringhomework.services;

import com.example.techiteasyspringhomework.dtos.mappers.CIModuleMapper;
import com.example.techiteasyspringhomework.dtos.outputDtos.TelevisionOutputDto;
import com.example.techiteasyspringhomework.dtos.inputDtos.TelevisionInputDto;
import com.example.techiteasyspringhomework.dtos.mappers.TelevisionMapper;
import com.example.techiteasyspringhomework.exceptions.RecordNotFoundException;
import com.example.techiteasyspringhomework.models.Television;
import com.example.techiteasyspringhomework.repositories.CIModuleRepository;
import com.example.techiteasyspringhomework.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final CIModuleRepository ciModuleRepository;

    public TelevisionService(TelevisionRepository televisionRepository, CIModuleRepository ciModuleRepository) {
        this.televisionRepository = televisionRepository;
        this.ciModuleRepository = ciModuleRepository;
    }

    public TelevisionOutputDto createTelevision(TelevisionInputDto televisionInputDto) {
        Television t = televisionRepository.save(TelevisionMapper.fromInputDtoToModel(televisionInputDto));
            return TelevisionMapper.fromModelToDto(t);
    }

    public List<TelevisionOutputDto> getAllTelevisions() {
        List<Television> allTelevisions = televisionRepository.findAll();
        List<TelevisionOutputDto> televisionDtos = new ArrayList<>();
        for (Television t : allTelevisions) {
            televisionDtos.add(TelevisionMapper.fromModelToDto(t));
        }
        return televisionDtos;
    }

    public TelevisionOutputDto getTelevisionById(Long id) {
        if(televisionRepository.findById(id).isPresent()) {
            Television television = televisionRepository.findById(id).get();
            TelevisionOutputDto dto = TelevisionMapper.fromModelToDto(television);
            if (television.getCiModule() != null) {
                dto.setCiModuleOutputDto(CIModuleMapper.fromModelToDto(television.getCiModule()));
            } return TelevisionMapper.fromModelToDto(television);
        } else {
            throw new RecordNotFoundException("No tv found.");
        }
    }

    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }

    public TelevisionOutputDto updateTelevision(Long id, TelevisionInputDto updatedTelevision) {
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

    public void assignCIModuleToTelevision(Long id, Long ciModuleId) {
        var optionalTelevision = televisionRepository.findById(id);
        var optionalCIModule = ciModuleRepository.findById(ciModuleId);

        if(optionalTelevision.isPresent() && optionalCIModule.isPresent()) {
            var television = optionalTelevision.get();
            var ciModule = optionalCIModule.get();

            television.setCiModule(ciModule);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
