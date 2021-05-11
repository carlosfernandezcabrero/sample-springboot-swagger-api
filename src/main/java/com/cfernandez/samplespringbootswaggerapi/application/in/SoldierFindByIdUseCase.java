package com.cfernandez.samplespringbootswaggerapi.application.in;

import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;

public interface SoldierFindByIdUseCase {

    /**
     * Method that has the logic for find a Soldier by his ID
     * @param id ID
     * @return Optional of Soldier
     */
    Optional<SoldierEntity> findById(Integer id);
    
}
