package com.cfernandez.samplespringbootswaggerapi.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.application.out.SoldierPort;
import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@DisplayName("Soldier service")
class SoldierServiceTest {

    @InjectMocks private SoldierService soldierService;

    @Mock private SoldierPort soldierPort;

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
        Mockito.when(soldierPort.findAll()).thenReturn(Collections.singletonList(SOLDIER));

        final List<Soldier> response = soldierService.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
    }
    
    @Test
    @DisplayName("Find by ID and return data")
    void testFindById() {
    	Mockito.when(soldierPort.findById(ID)).thenReturn(Optional.of(SOLDIER));
    	
    	final Optional<Soldier> response = soldierService.findById(ID);
    	
    	assertNotNull(response);
    	assertTrue(response.isPresent());
    }
    
}
