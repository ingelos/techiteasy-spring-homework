package com.example.techiteasyspringhomework.controllers;

import com.example.techiteasyspringhomework.exceptions.RecordNotFoundException;
import com.example.techiteasyspringhomework.models.Television;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private ArrayList<Television> televisions = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions() {
        if (!televisions.isEmpty()) {
            return ResponseEntity.ok(televisions);
        } else {
            throw new RecordNotFoundException("No televisions found.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable int id) {
        if (id < televisions.size() && id >= 0) {
            return ResponseEntity.ok(televisions.get(id));
        } else {
            throw new RecordNotFoundException("Television not found.");
        }
    }

    @PostMapping
    public ResponseEntity<Television> addTelevision(@RequestBody Television television) {
        televisions.add(television);
        return ResponseEntity.created(null).body(television);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable int id, @RequestBody Television updatedTelevision) {
        if (id >= 0 && id < televisions.size()) {
            televisions.set(id, updatedTelevision);
            return ResponseEntity.ok(updatedTelevision);
        } else {
            throw new RecordNotFoundException("Id " + id + " not found.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable int id) {
        if (id >= 0 && id < televisions.size()) {
            televisions.remove(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new RecordNotFoundException("Id " + id + " not found.");
        }
    }

}
