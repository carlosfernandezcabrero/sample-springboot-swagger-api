package com.cfernandez.samplespringbootswaggerapi.application.out;

import java.util.List;
import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

public interface SoldierPort {

    List<Soldier> findAll();
    
    Optional<Soldier> findById(Integer id);
    
    void deleteById(Integer id);
    
}
