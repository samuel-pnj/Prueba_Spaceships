//package com.example.spaceships.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//
//import com.example.spaceships.model.Spaceship.Spaceship;
//import com.example.spaceships.repository.SpaceshipRepository;
//
//public class SpaceshipServiceTest {
//
//    @Mock
//    private SpaceshipRepository spaceshipRepository;
//
//    @InjectMocks
//    private SpaceshipService spaceshipService;
//
//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testGetAllSpaceships() {
//        // Given
//        List<Spaceship> spaceships = new ArrayList<>();
//        spaceships.add(new Spaceship(1L, "Millennium Falcon", "YT-1300"));
//        spaceships.add(new Spaceship(2L, "X-wing", "T-65B"));
//        spaceships.add(new Spaceship(3L, "Imperial Star Destroyer", "Imperial-class"));
//        Page<Spaceship> page = new PageImpl<>(spaceships);
//        when(spaceshipRepository.findAll(PageRequest.of(0, 10))).thenReturn(page);
//
//        // When
//        List<Spaceship> result = spaceshipService.getAllSpaceships(0, 10);
//
//        // Then
//        assertEquals(3, result.size());
//    }
//
//    @Test
//    public void testGetSpaceshipById() {
//        // Given
//        Spaceship spaceship = new Spaceship(1L, "Millennium Falcon", "YT-1300");
//        when(spaceshipRepository.findById(1L)).thenReturn(Optional.of(spaceship));
//
//        // When
//        Optional<Spaceship> result = spaceshipService.getSpaceshipById(1L);
//
//        // Then
//        assertEquals(spaceship, result.get());
//    }
//    
//    @Test
//    public void testSearchSpaceshipsByName() {
//        String name = "Millennium Falcon";
//        List<Spaceship> expectedSpaceships = new ArrayList<>();
//        Spaceship spaceship1 = new Spaceship(1L, "Millennium Falcon", "YT-1300");
//        spaceship1.setName("Millennium Falcon");
//        expectedSpaceships.add(spaceship1);
//
//        when(spaceshipRepository.findByNameContaining(name)).thenReturn(expectedSpaceships);
//
//        List<Spaceship> actualSpaceships = spaceshipService.searchSpaceshipsByName(name);
//
//        assertEquals(expectedSpaceships, actualSpaceships);
//    }
//
//    @Test
//    public void testCreateSpaceship() {
//        Spaceship spaceshipToCreate = new Spaceship(1L, "Millennium Falcon", "YT-1300");
//        Spaceship expectedSpaceship = new Spaceship(1L, "Millennium Falcon", "YT-1300");
//        when(spaceshipRepository.save(spaceshipToCreate)).thenReturn(expectedSpaceship);
//
//        Spaceship actualSpaceship = spaceshipService.createSpaceship(spaceshipToCreate);
//
//        assertEquals(expectedSpaceship, actualSpaceship);
//    }
//
//    @Test
//    public void testUpdateSpaceship() {
//        Long id = 1L;
//        Spaceship spaceshipToUpdate = new Spaceship(1L, "Millennium Falcon", "YT-1300");
//        spaceshipToUpdate.setId(id);
//        Optional<Spaceship> existingSpaceship = Optional.of(new Spaceship(2L, "Millennium Falcon", "YT-1300"));
//        when(spaceshipRepository.findById(id)).thenReturn(existingSpaceship);
//        when(spaceshipRepository.save(spaceshipToUpdate)).thenReturn(spaceshipToUpdate);
//
//        Spaceship updatedSpaceship = spaceshipService.updateSpaceship(id, spaceshipToUpdate);
//
//        assertEquals(spaceshipToUpdate, updatedSpaceship);
//    }
//
//    @Test
//    public void testDeleteSpaceship() {
//        Long id = 1L;
//        Optional<Spaceship> existingSpaceship = Optional.of(new Spaceship(1L, "Millennium Falcon", "YT-1300"));
//        when(spaceshipRepository.findById(id)).thenReturn(existingSpaceship);
//
//        spaceshipService.deleteSpaceship(id);
//
//        verify(spaceshipRepository, times(1)).deleteById(id);
//    }
//    }
//
//   
