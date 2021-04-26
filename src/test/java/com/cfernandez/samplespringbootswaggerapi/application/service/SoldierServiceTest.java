package com.cfernandez.samplespringbootswaggerapi.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.cfernandez.samplespringbootswaggerapi.application.out.SoldierPort;
import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class SoldierServiceTest {

    @InjectMocks
    private SoldierService soldierService;

    @Mock
    private SoldierPort soldierPort;

    private static Soldier SOLDIER;
    private static List<Soldier> SOLDIERS;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        SOLDIERS = new ArrayList<>();

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

        SOLDIERS.add(SOLDIER);
    }

    @Test
    void testFindAll(){
        Mockito.when(soldierPort.findAll()).thenReturn(SOLDIERS);

        final List<Soldier> response = soldierService.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
    }
    
}
