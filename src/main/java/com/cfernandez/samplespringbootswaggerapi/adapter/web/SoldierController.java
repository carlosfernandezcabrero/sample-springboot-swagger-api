package com.cfernandez.samplespringbootswaggerapi.adapter.web;

import java.util.List;
import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierDeleteById;
import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierFindAllUseCase;
import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierFindByIdUseCase;
import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/soldiers",
				produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "soldier",
	description = "Use for manage soldiers and get information about them",
	value = "Soldier")
class SoldierController {

    @Autowired private SoldierFindAllUseCase soldierFindAllUseCase;
    @Autowired private SoldierFindByIdUseCase soldierFindByIdUseCase;
    @Autowired private SoldierDeleteById soldierDeleteById;

    @GetMapping("/")
    @ApiOperation(tags = "soldier", value = "Find all soldiers")
    public ResponseEntity<List<Soldier>> findAll() {
        return ResponseEntity.ok().body(soldierFindAllUseCase.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(tags = "soldier", value = "Find soldier by Id")
    public ResponseEntity<Soldier> findById(@RequestParam Integer id){
        Optional<Soldier> optionalSoldier = soldierFindByIdUseCase.findById(id);
        if (optionalSoldier.isPresent()){
            return ResponseEntity.ok().body(optionalSoldier.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    
    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(tags = "soldier", value = "Delete soldier by Id")
    public ResponseEntity<String> deleteById(@RequestParam Integer id){
    	soldierDeleteById.deleteById(id);
    	return ResponseEntity.ok().body("The soldier was successfully removed");
    }

}
