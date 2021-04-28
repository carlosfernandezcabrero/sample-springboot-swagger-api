package com.cfernandez.samplespringbootswaggerapi.application.in;

import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

public interface SoldierFindByIdUseCase {

    Optional<Soldier> findById(Integer id);
    
}
