package com.cfernandez.samplespringbootswaggerapi.application.service;

import java.util.List;

import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierFindAllUseCase;
import com.cfernandez.samplespringbootswaggerapi.application.out.SoldierPort;
import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoldierService implements SoldierFindAllUseCase {
    
    @Autowired
    private SoldierPort soldierPort;

    @Override
    public List<Soldier> findAll() {
        return soldierPort.findAll();
    }
    
}
