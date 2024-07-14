package com.example.techiteasyspringhomework.controllers;

import com.example.techiteasyspringhomework.dtos.inputDtos.CIModuleInputDto;
import com.example.techiteasyspringhomework.dtos.inputDtos.TelevisionInputDto;
import com.example.techiteasyspringhomework.dtos.outputDtos.CIModuleOutputDto;
import com.example.techiteasyspringhomework.dtos.outputDtos.TelevisionOutputDto;
import com.example.techiteasyspringhomework.models.CIModule;
import com.example.techiteasyspringhomework.models.Television;
import com.example.techiteasyspringhomework.services.CIModuleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cimodules")
public class CIModuleController {

    private final CIModuleService ciModuleService;

    public CIModuleController(CIModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }


    @PostMapping
    public ResponseEntity<CIModuleOutputDto> createCIModule(@Valid @RequestBody CIModuleInputDto ciModuleInputDto) {
        CIModuleOutputDto ci = ciModuleService.createCIModule(ciModuleInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + ci.getId()).toUriString());
        return ResponseEntity.created(uri).body(ci);
    }

    @GetMapping
    public ResponseEntity<List<CIModuleOutputDto>> getAllCIModules() {
        return ResponseEntity.ok().body(ciModuleService.getAllCIModules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CIModuleOutputDto> getCIModule(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(ciModuleService.getCIModuleById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CIModule> deleteCIModule(@PathVariable Long id) {
        ciModuleService.deleteCIModule(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CIModuleOutputDto> updateCIModule(@PathVariable("id") Long id, @Valid @RequestBody CIModuleInputDto updatedCIModule) {
        CIModuleOutputDto ci = ciModuleService.updateCIModule(id, updatedCIModule);
        return ResponseEntity.ok().body(ci);
    }
}

