package com.example.techiteasyspringhomework.controllers;

import com.example.techiteasyspringhomework.dtos.outputDtos.TelevisionOutputDto;
import com.example.techiteasyspringhomework.dtos.inputDtos.TelevisionInputDto;
import com.example.techiteasyspringhomework.models.Television;
import com.example.techiteasyspringhomework.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;



@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @PostMapping
    public ResponseEntity<TelevisionOutputDto> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionOutputDto t = televisionService.createTelevision(televisionInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/" + t.getId()).toUriString());
        return ResponseEntity.created(uri).body(t);
        }

    @GetMapping
    public ResponseEntity<List<TelevisionOutputDto>> getAllTelevisions() {
            return ResponseEntity.ok().body(televisionService.getAllTelevisions());
        }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> getTelevisionById(@PathVariable("id") Long id) {
            return ResponseEntity.ok().body(televisionService.getTelevisionById(id));
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> updateTelevision(@PathVariable("id") Long id, @Valid @RequestBody TelevisionInputDto updatedTelevision) {
        TelevisionOutputDto t = televisionService.updateTelevision(id, updatedTelevision);
            return ResponseEntity.ok().body(t);
        }

    // andere entiteiten toevoegen aan Television

    @PutMapping("/{id}/{ciModuleId}")
    public ResponseEntity<Object> assignCIModuleToTelevision(@PathVariable("id") Long id, @PathVariable("ciModuleId") Long ciModuleId) {
        televisionService.assignCIModuleToTelevision(id, ciModuleId);
        return ResponseEntity.noContent().build();
    }


}



