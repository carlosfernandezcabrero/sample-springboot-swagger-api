package com.cfernandez.samplespringbootswaggerapi.adapter.persistence;

import java.util.List;
import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.application.out.SoldierPort;
import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SoldierRepositoryAdapter implements SoldierPort {

    @Autowired private SoldierRepository soldierRepository;

    @Override
    public List<SoldierEntity> findAll() {
        return (List<SoldierEntity>) soldierRepository.findAll();
    }

    @Override
    public Optional<SoldierEntity> findById(Integer id) {
        return soldierRepository.findById(id);
    }
    
    @Override
    public void deleteById(Integer id) {
    	soldierRepository.deleteById(id);
    }

    @Override
    public SoldierEntity update(SoldierEntity soldier) {
        return soldierRepository.save(soldier);
    }

    @Override
    public SoldierEntity save(SoldierEntity soldierEntity) {
        return soldierRepository.save(soldierEntity);
    }

}
