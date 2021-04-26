package com.cfernandez.samplespringbootswaggerapi.adapter.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;
import java.util.List;

import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierFindAllUseCase;
import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

class SoldierControllerTest {

    @InjectMocks
    private SoldierController sController;

    @Mock
    private SoldierFindAllUseCase findAllUseCase;

    private static Soldier SOLDIER;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        SOLDIER = new Soldier();
        SOLDIER.setId(1);
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
    void testFindAll(){
        Mockito.when(findAllUseCase.findAll()).thenReturn(Collections.singletonList(SOLDIER));
        
        final ResponseEntity<List<Soldier>> response = sController.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
    }
    
}
