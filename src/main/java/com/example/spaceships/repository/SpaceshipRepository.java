package com.example.spaceships.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spaceships.model.Spaceship.Spaceship;

public interface SpaceshipRepository extends JpaRepository<Spaceship, Long>{

	List<Spaceship>findByNameContaining(String name);
}
