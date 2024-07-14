package com.example.techiteasyspringhomework.services;

import com.example.techiteasyspringhomework.dtos.inputDtos.CIModuleInputDto;
import com.example.techiteasyspringhomework.dtos.mappers.CIModuleMapper;
import com.example.techiteasyspringhomework.dtos.outputDtos.CIModuleOutputDto;
import com.example.techiteasyspringhomework.exceptions.RecordNotFoundException;
import com.example.techiteasyspringhomework.models.CIModule;
import com.example.techiteasyspringhomework.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CIModuleService {

    private final CIModuleRepository ciModuleRepository;

    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }


    public CIModuleOutputDto createCIModule(CIModuleInputDto ciModuleInputDto) {
        CIModule ci = ciModuleRepository.save(CIModuleMapper.fromInputDtoToModel(ciModuleInputDto));
        return CIModuleMapper.fromModelToDto(ci);
    }


    public List<CIModuleOutputDto> getAllCIModules() {
        List<CIModule> allCIModules = ciModuleRepository.findAll();
        List<CIModuleOutputDto> ciModuleOutputDtos = new ArrayList<>();
        for (CIModule ci : allCIModules) {
            ciModuleOutputDtos.add(CIModuleMapper.fromModelToDto(ci));
        }
        return ciModuleOutputDtos;
    }

    public CIModuleOutputDto getCIModuleById(Long id) {
        Optional<CIModule> ci = ciModuleRepository.findById(id);
        if (ci.isPresent()) {
            return CIModuleMapper.fromModelToDto(ci.get());
        } else {
            throw new RecordNotFoundException("No cimodule found with id :" + id);
        }
    }

    public void deleteCIModule(Long id) {
        ciModuleRepository.deleteById(id);
    }

    public CIModuleOutputDto updateCIModule(Long id, CIModuleInputDto updatedCIModule) {
        Optional<CIModule> ci = ciModuleRepository.findById(id);
        if (ci.isPresent()) {
            CIModule ciModule1 = ci.get();
            ciModule1.setName(updatedCIModule.getName());
            ciModule1.setType(updatedCIModule.getType());
            ciModule1.setPrice(updatedCIModule.getPrice());
            CIModule returnCIModule = ciModuleRepository.save(ciModule1);
            return CIModuleMapper.fromModelToDto(returnCIModule);
        } else {
            throw new RecordNotFoundException("No cimodule found with id: " + id);
        }
    }
}
