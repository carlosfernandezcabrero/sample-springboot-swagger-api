package com.cfernandez.samplespringbootswaggerapi.application.in;

import com.cfernandez.samplespringbootswaggerapi.application.exception.ServiceException;
import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

public interface SoldierUpdateByIdUseCase {

    /**
     * Method that has the logic for update a Soldier
     * @param soldierUpdateDTO Soldier
     * @return SoldierEntity
     * @throws ServiceException Exception for Service layer
     */
    SoldierEntity updateById(SoldierUpdateDTO soldierUpdateDTO) throws ServiceException;
    
    @Setter
    @Getter
    final class SoldierUpdateDTO {
        
        @NotBlank private String id;
        @NotBlank private String type;
        @NotBlank private String description;

    }
    
}
