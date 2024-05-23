package com.example.spaceships.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.spaceships.model.Spaceship.Spaceship;
import com.example.spaceships.service.SpaceshipService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/spaceships")
public class SpaceshipController {

    @Autowired
    private SpaceshipService spaceshipService;

    @GetMapping
    public ResponseEntity<List<Spaceship>> getAllSpaceships(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size) {
        List<Spaceship> spaceships = spaceshipService.getAllSpaceships(page, size);
        return new ResponseEntity<>(spaceships, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Spaceship> getSpaceshipById(@PathVariable Long id) {
        Optional<Spaceship> spaceship = spaceshipService.getSpaceshipById(id);
        return spaceship.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Spaceship>> searchSpaceshipsByName(@RequestParam String name) {
        List<Spaceship> spaceships = spaceshipService.searchSpaceshipsByName(name);
        return new ResponseEntity<>(spaceships, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Spaceship> createSpaceship(@RequestBody Spaceship spaceship) {
        Spaceship newSpaceship = spaceshipService.createSpaceship(spaceship);
        return new ResponseEntity<>(newSpaceship, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<Spaceship> updateSpaceship(@PathVariable Long id, @RequestBody Spaceship spaceship) {
        Optional<Spaceship> existingSpaceship = spaceshipService.getSpaceshipById(id);
        if (existingSpaceship.isPresent()) {
            Spaceship updatedSpaceship = spaceshipService.updateSpaceship(id, spaceship);
            return new ResponseEntity<>(updatedSpaceship, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteSpaceship(@PathVariable Long id) {
        Optional<Spaceship> existingSpaceship = spaceshipService.getSpaceshipById(id);
        if (existingSpaceship.isPresent()) {
            spaceshipService.deleteSpaceship(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
