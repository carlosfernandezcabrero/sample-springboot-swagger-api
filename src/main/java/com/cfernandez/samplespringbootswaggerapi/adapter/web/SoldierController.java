package com.cfernandez.samplespringbootswaggerapi.adapter.web;

import java.util.List;

import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierFindAllUseCase;
import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soldiers")
class SoldierController {

    @Autowired
    private SoldierFindAllUseCase soldierFindAllUseCase;

    @GetMapping(value = "/",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Soldier>> findAll() {
        return ResponseEntity.ok().body(soldierFindAllUseCase.findAll());
    }

}
