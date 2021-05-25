package com.cfernandez.samplespringbootswaggerapi.application.service;

import com.cfernandez.samplespringbootswaggerapi.application.exception.ServiceException;
import java.util.List;
import java.util.Optional;

import com.cfernandez.samplespringbootswaggerapi.application.in.*;
import com.cfernandez.samplespringbootswaggerapi.application.out.SoldierPort;
import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoldierService implements
        SoldierFindAllUseCase,
        SoldierFindByIdUseCase,
        SoldierDeleteByIdUseCase,
        SoldierUpdateByIdUseCase,
        SoldierSaveUseCase {
    
    @Autowired private SoldierPort soldierPort;

    @Override
    public List<SoldierEntity> findAll() {
        return soldierPort.findAll();
    }

    @Override
    public Optional<SoldierEntity> findById(Integer id) {
        return soldierPort.findById(id);
    }

	@Override
	public void deleteById(Integer id) {
		soldierPort.deleteById(id);
	}

    @Override
    public SoldierEntity updateById(SoldierUpdateDTO soldierUpdateDTO) throws ServiceException {
        try {
            final Integer ID = Integer.parseInt(soldierUpdateDTO.getId());
            Optional<SoldierEntity> soldierEntity = findById(ID);

            if (soldierEntity.isPresent()) {
                var soldier = soldierEntity.get();
                soldier.setId(ID);
                soldier.setType(soldierUpdateDTO.getType());
                soldier.setDescription(soldierUpdateDTO.getDescription());

                return soldierPort.update(soldier);
            } else {
                throw new ServiceException("No exist the soldier with ID: " + ID);
            }
        } catch(NumberFormatException e){
            throw new ServiceException("The ID must be a number");
        }
    }

    @Override
    public SoldierEntity save(SoldierSaveDTO soldierSaveDTO) throws ServiceException {
        var soldierEntity = new SoldierEntity();
        var lastField = "";

        try {
            soldierEntity.setName(soldierSaveDTO.getName());
            lastField = "combatPower";
            soldierEntity.setCombatPower(Integer.parseInt(soldierSaveDTO.getCombatPower()));
            lastField = "strengthSoldierMeeting";
            soldierEntity.setStrengthSoldierMeeting(Integer.parseInt(soldierSaveDTO.getStrengthSoldierMeeting()));
            lastField = "strengthDistanceSoldiers";
            soldierEntity.setStrengthDistanceSoldiers(Integer.parseInt(soldierSaveDTO.getStrengthDistanceSoldiers()));
            lastField = "lootingCapacity";
            soldierEntity.setLootingCapacity(Integer.parseInt(soldierSaveDTO.getLootingCapacity()));
            lastField = "travelVelocity";
            soldierEntity.setTravelVelocity(Integer.parseInt(soldierSaveDTO.getTravelVelocity()));
            lastField = "food";
            soldierEntity.setFood(Integer.parseInt(soldierSaveDTO.getFood()));
            soldierEntity.setType(soldierSaveDTO.getType());
            soldierEntity.setDescription(soldierSaveDTO.getDescription());

            return soldierPort.save(soldierEntity);
        } catch(NumberFormatException e){
            throw new ServiceException("The field " + lastField + " must be a number");
        }
    }
}
