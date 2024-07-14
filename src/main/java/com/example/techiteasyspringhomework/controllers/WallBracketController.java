package com.example.techiteasyspringhomework.controllers;

import com.example.techiteasyspringhomework.dtos.inputDtos.TelevisionInputDto;
import com.example.techiteasyspringhomework.dtos.inputDtos.WallBracketInputDto;
import com.example.techiteasyspringhomework.dtos.outputDtos.TelevisionOutputDto;
import com.example.techiteasyspringhomework.dtos.outputDtos.WallBracketOutputDto;
import com.example.techiteasyspringhomework.models.Television;
import com.example.techiteasyspringhomework.models.WallBracket;
import com.example.techiteasyspringhomework.services.WallBracketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @PostMapping
    public ResponseEntity<WallBracketOutputDto> createWallBracket(@Valid @RequestBody WallBracketInputDto wallBracketInputDto) {
        WallBracketOutputDto wb = wallBracketService.createWallBracket(wallBracketInputDto);
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + wb.getId()).toUriString());
        return ResponseEntity.created(uri).body(wb);
    }

    @GetMapping
    public ResponseEntity<List<WallBracketOutputDto>> getAllWallBrackets() {
        return ResponseEntity.ok().body(wallBracketService.getAllWallBrackets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketOutputDto> getWallBracket(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(wallBracketService.getWallBracketById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WallBracket> deleteWallBracket(@PathVariable Long id) {
        wallBracketService.deleteWallBracket(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketOutputDto> updateWallBracket(@PathVariable("id") Long id, @Valid @RequestBody WallBracketInputDto updatedWallBracket) {
        WallBracketOutputDto wb = wallBracketService.updateWallBracket(id, updatedWallBracket);
        return ResponseEntity.ok().body(wb);
    }
}



