package com.example.spaceships.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.spaceships.model.Spaceship.Spaceship;
import com.example.spaceships.repository.SpaceshipRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceshipService {

    @Autowired
    private SpaceshipRepository spaceshipRepository;

    public List<Spaceship> getAllSpaceships(int page, int size) {
        Page<Spaceship> resultPage = spaceshipRepository.findAll(PageRequest.of(page, size));
        return resultPage.getContent();
    }

    public Optional<Spaceship> getSpaceshipById(Long id) {
        return spaceshipRepository.findById(id);
    }

    public List<Spaceship> searchSpaceshipsByName(String name) {
        return spaceshipRepository.findByNameContaining(name);
    }

    public Spaceship createSpaceship(Spaceship spaceship) {
        return spaceshipRepository.save(spaceship);
    }

    public Spaceship updateSpaceship(Long id, Spaceship spaceship) {
        Optional<Spaceship> existingSpaceship = spaceshipRepository.findById(id);
        if (existingSpaceship.isPresent()) {
            spaceship.setId(id);
            return spaceshipRepository.save(spaceship);
        } else {
            throw new RuntimeException("Spaceship not found with id: " + id);
        }
    }

    public void deleteSpaceship(Long id) {
        Optional<Spaceship> existingSpaceship = spaceshipRepository.findById(id);
        if (existingSpaceship.isPresent()) {
            spaceshipRepository.deleteById(id);
        } else {
            throw new RuntimeException("Spaceship not found with id: " + id);
        }
    }
}
