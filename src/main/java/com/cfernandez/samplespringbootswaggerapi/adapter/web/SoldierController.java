package com.cfernandez.samplespringbootswaggerapi.adapter.web;

import java.util.List;
import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierFindAllUseCase;
import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierFindByIdUseCase;
import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/soldiers")
@Api(tags = "Soldier")
class SoldierController {

    @Autowired
    private SoldierFindAllUseCase soldierFindAllUseCase;

    @Autowired
    private SoldierFindByIdUseCase soldierFindByIdUseCase;

    @GetMapping(value = "/",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Soldier>> findAll() {
        return ResponseEntity.ok().body(soldierFindAllUseCase.findAll());
    }

    @GetMapping(value = "/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Soldier> findById(@RequestParam Integer id){
        Optional<Soldier> optionalSoldier = soldierFindByIdUseCase.findById(id);
        if (optionalSoldier.isPresent()){
            return ResponseEntity.ok().body(optionalSoldier.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
