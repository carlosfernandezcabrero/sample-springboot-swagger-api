package com.cfernandez.samplespringbootswaggerapi.adapter.web;

import com.cfernandez.samplespringbootswaggerapi.application.exception.ControllerException;
import com.cfernandez.samplespringbootswaggerapi.application.exception.ServiceException;
import java.util.List;
import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.application.in.*;
import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/soldiers",
                produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "soldier",
     value = "Soldier")
class SoldierController {

    @Autowired private SoldierFindAllUseCase soldierFindAllUseCase;
    @Autowired private SoldierFindByIdUseCase soldierFindByIdUseCase;
    @Autowired private SoldierDeleteByIdUseCase soldierDeleteByIdUseCase;
    @Autowired private SoldierUpdateByIdUseCase soldierUpdateByIdUseCase;
    @Autowired private SoldierSaveUseCase soldierSaveUseCase;

    @GetMapping("/")
    @ApiOperation(tags = "soldier", value = "Find all soldiers")
    public ResponseEntity<List<SoldierEntity>> findAll() {
        return ResponseEntity.ok().body(soldierFindAllUseCase.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(tags = "soldier", value = "Find soldier by his ID")
    public ResponseEntity<SoldierEntity> findById(@PathVariable Integer id){
        Optional<SoldierEntity> optionalSoldier = soldierFindByIdUseCase.findById(id);
        return optionalSoldier.map(soldierEntity -> ResponseEntity.ok().body(soldierEntity)).orElseGet(() -> ResponseEntity.noContent().build());
    }
    
    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(tags = "soldier", value = "Delete soldier by his ID")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
    	soldierDeleteByIdUseCase.deleteById(id);
    	return ResponseEntity.ok().body("The soldier was successfully removed");
    }
    
    @PutMapping(value = "/")
    @ApiOperation(tags = "soldier", value ="Update soldier")
    public ResponseEntity<SoldierEntity> update(@Valid @RequestBody SoldierUpdateByIdUseCase.SoldierUpdateDTO soldierUpdateDTO,
                                                BindingResult bindingResult) {
        try{
            if (bindingResult.hasFieldErrors()){
                var error = bindingResult.getFieldError();
                if (error != null) {
                    throw new ControllerException("The field " + error.getField() + ": " + error.getDefaultMessage());
                } else {
                    throw new ControllerException("Internal error on validation data");
                }
            } else {
                return ResponseEntity.ok().body(soldierUpdateByIdUseCase.updateById(soldierUpdateDTO));
            }
        } catch(ServiceException e) {
            throw new ControllerException(e, e.getMessage());
        }
    }

    @PostMapping(value = "/")
    @ApiOperation(tags = "soldier", value ="Save soldier")
    public ResponseEntity<SoldierEntity> save(@Valid @RequestBody SoldierSaveUseCase.SoldierSaveDTO soldierSaveDTO,
                                              BindingResult bindingResult) {
        try {
            if (bindingResult.hasFieldErrors()){
                var error = bindingResult.getFieldError();
                if (error != null) {
                    throw new ControllerException("The field " + error.getField() + ": " + error.getDefaultMessage());
                } else {
                    throw new ControllerException("Internal error on validation data");
                }
            } else {
                return ResponseEntity.ok().body(soldierSaveUseCase.save(soldierSaveDTO));
            }
        } catch (ServiceException e) {
            throw new ControllerException(e, e.getMessage());
        }
    }

}
