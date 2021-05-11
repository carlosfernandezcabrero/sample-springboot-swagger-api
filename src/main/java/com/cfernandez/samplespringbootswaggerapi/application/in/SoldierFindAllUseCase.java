package com.cfernandez.samplespringbootswaggerapi.application.in;

import java.util.List;

import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;

public interface SoldierFindAllUseCase {

    /**
     * Method that has the logic for find all Soldiers
     * @return List of Soldiers
     */
    List<SoldierEntity> findAll();
    
}
