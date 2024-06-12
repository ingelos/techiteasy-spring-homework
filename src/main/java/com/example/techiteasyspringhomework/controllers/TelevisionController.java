package com.example.techiteasyspringhomework.controllers;

import com.example.techiteasyspringhomework.dtos.TelevisionDto;
import com.example.techiteasyspringhomework.dtos.TelevisionInputDto;
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
    public ResponseEntity<TelevisionDto> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionDto t = televisionService.createTelevision(televisionInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/" + t.getId()).toUriString());
        return ResponseEntity.created(uri).body(t);
        }

    @GetMapping
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
            return ResponseEntity.ok().body(televisionService.getAllTelevisions());
        }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable("id") Long id) {
            return ResponseEntity.ok().body(televisionService.getTelevisionById(id));
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable("id") Long id, @Valid @RequestBody TelevisionInputDto updatedTelevision) {
        TelevisionDto t = televisionService.updateTelevision(id, updatedTelevision);
            return ResponseEntity.ok().body(t);
        }
    }




