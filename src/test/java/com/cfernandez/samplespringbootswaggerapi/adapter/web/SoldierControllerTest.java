package com.cfernandez.samplespringbootswaggerapi.adapter.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.application.exception.ControllerException;
import com.cfernandez.samplespringbootswaggerapi.application.exception.ServiceException;
import com.cfernandez.samplespringbootswaggerapi.application.in.*;
import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@DisplayName("Soldier controller")
class SoldierControllerTest {

    @InjectMocks private SoldierController sController;

    @Mock private SoldierFindAllUseCase findAllUseCase;
    @Mock private SoldierFindByIdUseCase findByIdUseCase;
    @Mock private SoldierDeleteByIdUseCase soldierDeleteByIdUseCase;
    @Mock private SoldierUpdateByIdUseCase soldierUpdateByIdUseCase;
    @Mock private SoldierSaveUseCase soldierSaveUseCase;

    @Mock private BindingResult bindingResult;
    @Mock private FieldError fieldError;
    
    private static final Integer ID = 1;
    private static final String TYPE = "N/A";
    private static final String DESCRIPTION = "test";
    
    private static SoldierEntity soldierEntity;
    private static final SoldierUpdateByIdUseCase.SoldierUpdateDTO SOLDIER_UPDATE_DTO = new SoldierUpdateByIdUseCase.SoldierUpdateDTO();
    private static final SoldierSaveUseCase.SoldierSaveDTO SOLDIER_SAVE_DTO = new SoldierSaveUseCase.SoldierSaveDTO();

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
        soldierEntity.setType(TYPE);
        soldierEntity.setDescription(DESCRIPTION);
    }

    @Test
    @DisplayName("Find all")
    void testFindAll(){
        when(findAllUseCase.findAll()).thenReturn(Collections.singletonList(soldierEntity));
        
        final ResponseEntity<List<SoldierEntity>> response = sController.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    @DisplayName("Find by ID and return data")
    void findByIdFound() {
    	when(findByIdUseCase.findById(ID)).thenReturn(Optional.of(soldierEntity));
    	
    	final ResponseEntity<SoldierEntity> response = sController.findById(ID);
    	
    	assertNotNull(response);
    	assertNotNull(response.getBody());
    	assertEquals(soldierEntity, response.getBody());
    	assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    @DisplayName("Find by ID without data")
    void findByIdNotFound() {
    	when(findByIdUseCase.findById(ID)).thenReturn(Optional.empty());
    	
    	final ResponseEntity<SoldierEntity> response = sController.findById(ID);
    	
    	assertNotNull(response);
        assertNull(response.getBody());
    	assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @DisplayName("Delete by ID")
    @Test
    void deleteById(){
        doNothing().when(soldierDeleteByIdUseCase).deleteById(ID);

        final ResponseEntity<String> response = sController.deleteById(ID);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @DisplayName("Update soldier")
    @Test
    void update(){
        try {
            when(bindingResult.hasFieldErrors()).thenReturn(false);
            when(soldierUpdateByIdUseCase.updateById(SOLDIER_UPDATE_DTO)).thenReturn(soldierEntity);

            final ResponseEntity<SoldierEntity> response = sController.update(SOLDIER_UPDATE_DTO, bindingResult);

            assertNotNull(response);
            assertNotNull(response.getBody());
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(soldierEntity, response.getBody());
        } catch (ServiceException e) {
            fail();
        }
    }

    @DisplayName("Update soldier when has errors in the validation")
    @Test
    void updateWhenValidationIsWrong(){
    	when(bindingResult.hasFieldErrors()).thenReturn(true);
        when(bindingResult.getFieldError()).thenReturn(fieldError);
        Assertions.assertThrows(ControllerException.class, () -> sController.update(SOLDIER_UPDATE_DTO, bindingResult));
    }

    @DisplayName("Update soldier when field error is null")
    @Test
    void updateWhenFieldErrorIsNull(){
    	when(bindingResult.hasFieldErrors()).thenReturn(true);
        when(bindingResult.getFieldError()).thenReturn(null);
        Assertions.assertThrows(ControllerException.class, () -> sController.update(SOLDIER_UPDATE_DTO, bindingResult));
    }

    @DisplayName("Update launches ServiceException")
    @Test
    void updateLaunchesServiceException(){
    	try {
    		when(bindingResult.hasFieldErrors()).thenReturn(false);
    		when(soldierUpdateByIdUseCase.updateById(SOLDIER_UPDATE_DTO)).thenThrow(ServiceException.class);
    		Assertions.assertThrows(ControllerException.class, () -> sController.update(SOLDIER_UPDATE_DTO, bindingResult));
    	} catch(ServiceException e) {
    		fail(e.getMessage());
    	}
    }

    @DisplayName("Save soldier")
    @Test
    void save(){
        try {
            when(soldierSaveUseCase.save(SOLDIER_SAVE_DTO)).thenReturn(soldierEntity);
            when(bindingResult.hasFieldErrors()).thenReturn(false);

            final ResponseEntity<SoldierEntity> response = sController.save(SOLDIER_SAVE_DTO, bindingResult);

            assertNotNull(response);
            assertNotNull(response.getBody());
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(soldierEntity, response.getBody());
        } catch (ServiceException e){
            fail();
        }
    }

    @DisplayName("Save soldier when has errors in the validation")
    @Test
    void saveWhenValidationIsWrong(){
    	when(bindingResult.hasFieldErrors()).thenReturn(true);
        when(bindingResult.getFieldError()).thenReturn(fieldError);
        Assertions.assertThrows(ControllerException.class, () -> sController.save(SOLDIER_SAVE_DTO, bindingResult));
    }

    @DisplayName("Save soldier when field error is null")
    @Test
    void saveWhenFieldErrorIsNull(){
    	when(bindingResult.hasFieldErrors()).thenReturn(true);
        when(bindingResult.getFieldError()).thenReturn(null);
        Assertions.assertThrows(ControllerException.class, () -> sController.save(SOLDIER_SAVE_DTO, bindingResult));
    }

    @DisplayName("Save launches ServiceException")
    @Test
    void saveLaunchesServiceException() {
    	try {
    		when(bindingResult.hasFieldErrors()).thenReturn(false);
    		when(soldierSaveUseCase.save(SOLDIER_SAVE_DTO)).thenThrow(ServiceException.class);
    		Assertions.assertThrows(ControllerException.class, () -> sController.save(SOLDIER_SAVE_DTO, bindingResult));
    	} catch(ServiceException e) {
    		fail(e.getMessage());
    	}
    }
}
