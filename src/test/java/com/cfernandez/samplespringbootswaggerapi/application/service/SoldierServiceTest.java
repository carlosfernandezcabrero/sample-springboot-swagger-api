package com.cfernandez.samplespringbootswaggerapi.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.application.exception.ServiceException;
import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierSaveUseCase;
import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierUpdateByIdUseCase;
import com.cfernandez.samplespringbootswaggerapi.application.out.SoldierPort;
import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@DisplayName("Soldier service")
class SoldierServiceTest {

    @InjectMocks private SoldierService soldierService;

    @Mock private SoldierPort soldierPort;

    private static final Integer ID = 1;
    private static final SoldierUpdateByIdUseCase.SoldierUpdateDTO SOLDIER_UPDATE_DTO = new SoldierUpdateByIdUseCase.SoldierUpdateDTO();
    private static SoldierSaveUseCase.SoldierSaveDTO SOLDIER_SAVE_DTO = new SoldierSaveUseCase.SoldierSaveDTO();

    private static SoldierEntity soldierEntity;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        soldierEntity = new SoldierEntity();
        soldierEntity.setId(ID);
        soldierEntity.setName("My soldier");
        soldierEntity.setCombatPower(90);
        soldierEntity.setStrengthDistanceSoldiers(90);
        soldierEntity.setStrengthSoldierMeeting(90);
        soldierEntity.setLootingCapacity(90);
        soldierEntity.setTravelVelocity(90);
        soldierEntity.setFood(50);
        soldierEntity.setType("T");
        soldierEntity.setDescription("this is a test");
    }

    @Test
    @DisplayName("Find all")
    void testFindAll(){
        when(soldierPort.findAll()).thenReturn(Collections.singletonList(soldierEntity));

        final List<SoldierEntity> response = soldierService.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
    }
    
    @Test
    @DisplayName("Find by ID")
    void testFindById() {
    	when(soldierPort.findById(ID)).thenReturn(Optional.of(soldierEntity));
    	
    	final Optional<SoldierEntity> response = soldierService.findById(ID);
    	
    	assertNotNull(response);
    	assertTrue(response.isPresent());
    	assertEquals(soldierEntity, response.get());
    }

    @Test
    @DisplayName("Delete by ID")
    void deleteById(){
        doNothing().when(soldierPort).deleteById(ID);
        soldierService.deleteById(ID);
    }

    @Test
    @DisplayName("Update")
    void update(){
        try {
            SOLDIER_UPDATE_DTO.setId(String.valueOf(ID));
            when(soldierPort.findById(ID)).thenReturn(Optional.of(soldierEntity));
            when(soldierPort.update(any(SoldierEntity.class))).thenReturn(soldierEntity);

            final SoldierEntity response = soldierService.updateById(SOLDIER_UPDATE_DTO);

            assertNotNull(response);
            assertEquals(soldierEntity, response);
        } catch(ServiceException e){
            fail(e.getMessage());
        }
    }

    @Test
    @DisplayName("Update with invalid ID")
    void updateWithInvalidId(){
        Assertions.assertThrows(ServiceException.class, () -> {
            SOLDIER_UPDATE_DTO.setId("1a");
            soldierService.updateById(SOLDIER_UPDATE_DTO);
        });
    }

    @Test
    @DisplayName("Update when the soldier does not exist")
    void updateSoldierNotExist(){
        Assertions.assertThrows(ServiceException.class, () -> {
            SOLDIER_UPDATE_DTO.setId(String.valueOf(ID));
            when(soldierPort.findById(ID)).thenReturn(Optional.empty());

            soldierService.updateById(SOLDIER_UPDATE_DTO);
        });
    }

    @Test
    @DisplayName("Save when launch ServiceException")
    void saveServiceException(){
        Assertions.assertThrows(ServiceException.class, () -> {
            SOLDIER_SAVE_DTO = new SoldierSaveUseCase.SoldierSaveDTO();
            when(soldierPort.save(any(SoldierEntity.class))).thenReturn(soldierEntity);

            final SoldierEntity response = soldierService.save(SOLDIER_SAVE_DTO);

            assertNotNull(response);
            assertEquals(soldierEntity, response);
        });
    }

    @Test
    @DisplayName("Save")
    void save(){
        try {
            when(soldierPort.save(any(SoldierEntity.class))).thenReturn(soldierEntity);

            SOLDIER_SAVE_DTO.setCombatPower("1");
            SOLDIER_SAVE_DTO.setStrengthSoldierMeeting("1");
            SOLDIER_SAVE_DTO.setStrengthDistanceSoldiers("1");
            SOLDIER_SAVE_DTO.setLootingCapacity("1");
            SOLDIER_SAVE_DTO.setTravelVelocity("1");
            SOLDIER_SAVE_DTO.setFood("1");

            final SoldierEntity response = soldierService.save(SOLDIER_SAVE_DTO);

            assertNotNull(response);
            assertEquals(soldierEntity, response);
        } catch(ServiceException e){
            fail(e.getMessage());
        }
    }
}
