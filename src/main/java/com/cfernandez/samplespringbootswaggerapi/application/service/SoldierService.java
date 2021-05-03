package com.cfernandez.samplespringbootswaggerapi.application.service;

import java.util.List;
import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierDeleteById;
import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierFindAllUseCase;
import com.cfernandez.samplespringbootswaggerapi.application.in.SoldierFindByIdUseCase;
import com.cfernandez.samplespringbootswaggerapi.application.out.SoldierPort;
import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoldierService implements SoldierFindAllUseCase, SoldierFindByIdUseCase,
										SoldierDeleteById {
    
    @Autowired
    private SoldierPort soldierPort;

    @Override
    public List<Soldier> findAll() {
        return soldierPort.findAll();
    }

    @Override
    public Optional<Soldier> findById(Integer id) {
        Soldier soldier = new Soldier();
        soldier.setId(id);

        return soldierPort.findById(soldier);
    }

	@Override
	public void deleteById(Integer id) {
		Soldier soldier = new Soldier();
		soldier.setId(id);
		
		soldierPort.deleteById(soldier);
	}
    
}
