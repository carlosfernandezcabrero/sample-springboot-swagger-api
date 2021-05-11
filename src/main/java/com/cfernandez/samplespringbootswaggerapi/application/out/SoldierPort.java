package com.cfernandez.samplespringbootswaggerapi.application.out;

import java.util.List;
import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;

public interface SoldierPort {

    /**
     * Method that find all Soldiers in the repository
     * @return List of Soldiers
     */
    List<SoldierEntity> findAll();

    /**
     * Method that find a Soldier by his ID in the repository
     * @param id ID
     * @return Optional of Soldier
     */
    Optional<SoldierEntity> findById(Integer id);

    /**
     * Method that delete a Soldier by his ID
     * @param id ID
     */
    void deleteById(Integer id);

    /**
     * Method that update a Soldier
     * @param soldier SoldierEntity
     * @return SoldierEntity
     */
    SoldierEntity update(SoldierEntity soldier);

    /**
     * Method that save a Soldier in the repository
     * @param soldierEntity SoldierEntity
     * @return SoldierEntity
     */
    SoldierEntity save(SoldierEntity soldierEntity);
    
}
