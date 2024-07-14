package com.example.techiteasyspringhomework.controllers;

import com.example.techiteasyspringhomework.dtos.inputDtos.RemoteControllerInputDto;
import com.example.techiteasyspringhomework.dtos.outputDtos.RemoteControllerOutputDto;
import com.example.techiteasyspringhomework.models.RemoteController;
import com.example.techiteasyspringhomework.services.RemoteControllerService;
import com.fasterxml.jackson.databind.ser.impl.ReadOnlyClassToSerializerMap;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.rmi.Remote;
import java.util.List;

@RestController
@RequestMapping("/remotecontrollers")
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;

    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @PostMapping
    public ResponseEntity<RemoteControllerOutputDto> createRemoteController(@Valid @RequestBody RemoteControllerInputDto remoteControllerInputDto) {
        RemoteControllerOutputDto rc = remoteControllerService.createRemoteController(remoteControllerInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + rc.getId()).toUriString());
        return ResponseEntity.created(uri).body(rc);
    }

    @GetMapping
    public ResponseEntity<List<RemoteControllerOutputDto>> getAllRemoteController() {
        return ResponseEntity.ok().body(remoteControllerService.getAllRemoteControllers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerOutputDto> getRemoteControllerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(remoteControllerService.getRemoteControllerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RemoteController> deleteRemoteController(@PathVariable Long id) {
        remoteControllerService.deleteRemoteController(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerOutputDto> updateRemoteController(@PathVariable("id") Long id, @Valid @RequestBody RemoteControllerInputDto updatedRemoteController) {
        RemoteControllerOutputDto rc = remoteControllerService.updateRemoteController(id, updatedRemoteController);
        return ResponseEntity.ok().body(rc);
    }


}
