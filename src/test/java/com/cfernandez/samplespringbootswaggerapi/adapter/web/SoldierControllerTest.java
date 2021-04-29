package com.cfernandez.samplespringbootswaggerapi.adapter.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierFindAllUseCase;
import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierFindByIdUseCase;
import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

@DisplayName("Soldier controller")
class SoldierControllerTest {

    @InjectMocks private SoldierController sController;

    @Mock private SoldierFindAllUseCase findAllUseCase;
    @Mock private SoldierFindByIdUseCase findByIdUseCase;
    
    private static final Integer ID = 1;
    
    private static Soldier SOLDIER;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        SOLDIER = new Soldier();
        SOLDIER.setId(ID);
        SOLDIER.setName("My soldier");
        SOLDIER.setCombatPower(90);
        SOLDIER.setStrengthDistanceSoldiers(90);
        SOLDIER.setStrengthSoldierMeeting(90);
        SOLDIER.setLootingCapacity(90);
        SOLDIER.setTravelVelocity(90);
        SOLDIER.setFood(50);
        SOLDIER.setType("T");
        SOLDIER.setDescription("this is a test");
    }

    @Test
    @DisplayName("Find all")
    void testFindAll(){
        Mockito.when(findAllUseCase.findAll()).thenReturn(Collections.singletonList(SOLDIER));
        
        final ResponseEntity<List<Soldier>> response = sController.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
    }
    
    @Test
    @DisplayName("Find by ID and return data")
    void findByIdFound() {
    	Mockito.when(findByIdUseCase.findById(ID)).thenReturn(Optional.of(SOLDIER));
    	
    	final ResponseEntity<Soldier> response = sController.findById(ID);
    	
    	assertNotNull(response);
    	assertNotNull(response.getBody());
    	assertEquals(SOLDIER, response.getBody());
    	assertEquals(200, response.getStatusCodeValue());
    }
    
    @Test
    @DisplayName("Find by ID without data")
    void findByIdNotFound() {
    	Mockito.when(findByIdUseCase.findById(ID)).thenReturn(Optional.empty());
    	
    	final ResponseEntity<Soldier> response = sController.findById(ID);
    	
    	assertNotNull(response);
    	assertNull(response.getBody());
    	assertEquals(204, response.getStatusCodeValue());
    }
    
}
