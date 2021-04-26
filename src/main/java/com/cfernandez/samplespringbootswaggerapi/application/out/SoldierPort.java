package com.cfernandez.samplespringbootswaggerapi.application.out;

import java.util.List;

import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

public interface SoldierPort {

    List<Soldier> findAll();
    
}
