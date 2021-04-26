package com.cfernandez.samplespringbootswaggerapi.application.in;

import java.util.List;

import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

public interface SoldierFindAllUseCase {

    List<Soldier> findAll();
    
}
