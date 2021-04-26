package com.cfernandez.samplespringbootswaggerapi.adapter.persistence;

import java.util.List;

import com.cfernandez.samplespringbootswaggerapi.application.out.SoldierPort;
import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SoldierRepositoryAdapter implements SoldierPort {

    @Autowired
    private SoldierRepository soldierRepository;

    @Override
    public List<Soldier> findAll() {
        return (List<Soldier>) soldierRepository.findAll();
    }
    
}
