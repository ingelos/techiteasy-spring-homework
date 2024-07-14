package com.example.techiteasyspringhomework.services;

import com.example.techiteasyspringhomework.dtos.inputDtos.RemoteControllerInputDto;
import com.example.techiteasyspringhomework.dtos.mappers.RemoteControllerMapper;
import com.example.techiteasyspringhomework.dtos.outputDtos.RemoteControllerOutputDto;
import com.example.techiteasyspringhomework.exceptions.RecordNotFoundException;
import com.example.techiteasyspringhomework.models.RemoteController;
import com.example.techiteasyspringhomework.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }


    public RemoteControllerOutputDto createRemoteController(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController rc  = remoteControllerRepository.save(RemoteControllerMapper.fromInputDtoToModel(remoteControllerInputDto));
        return RemoteControllerMapper.fromModelToOutputDto(rc);
    }

    public List<RemoteControllerOutputDto> getAllRemoteControllers() {
            List<RemoteController> allRemoteControllers = remoteControllerRepository.findAll();
            List<RemoteControllerOutputDto> remoteControllerDtos = new ArrayList<>();
            for (RemoteController rc : allRemoteControllers) {
                remoteControllerDtos.add(RemoteControllerMapper.fromModelToOutputDto(rc));
            }
            return remoteControllerDtos;
    }

    public RemoteControllerOutputDto getRemoteControllerById(Long id) {
        Optional<RemoteController> rc = remoteControllerRepository.findById(id);
        if (rc.isPresent()) {
            return RemoteControllerMapper.fromModelToOutputDto(rc.get());
        } else {
            throw new RecordNotFoundException(("No remote controller found with id: " + id));
        }
    }

    public void deleteRemoteController(Long id) {
        remoteControllerRepository.deleteById(id);
    }

    public RemoteControllerOutputDto updateRemoteController(Long id, RemoteControllerInputDto updatedRemoteController) {
        Optional<RemoteController> rc = remoteControllerRepository.findById(id);
        if(rc.isPresent()) {
            RemoteController rc1 = rc.get();
            rc1.setCompatibleWith(updatedRemoteController.getCompatibleWith());
            rc1.setBatteryType(updatedRemoteController.getBatteryType());
            rc1.setName(updatedRemoteController.getName());
            rc1.setBrand(updatedRemoteController.getBrand());
            rc1.setPrice(updatedRemoteController.getPrice());
            rc1.setOriginalStock(updatedRemoteController.getOriginalStock());

            RemoteController returnRemoteController = remoteControllerRepository.save(rc1);
            return RemoteControllerMapper.fromModelToOutputDto(returnRemoteController);
        } else {
            throw new RecordNotFoundException("No remotecontroller found");
        }

    }
}
