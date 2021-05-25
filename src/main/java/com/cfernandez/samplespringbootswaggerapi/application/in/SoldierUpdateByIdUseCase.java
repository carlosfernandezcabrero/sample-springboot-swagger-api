package com.cfernandez.samplespringbootswaggerapi.application.in;

import com.cfernandez.samplespringbootswaggerapi.application.exception.ServiceException;
import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;

import javax.validation.constraints.NotBlank;

public interface SoldierUpdateByIdUseCase {

    /**
     * Method that has the logic for update a Soldier
     * @param soldierUpdateDTO Soldier
     * @return SoldierEntity
     * @throws ServiceException Exception for Service layer
     */
    SoldierEntity updateById(SoldierUpdateDTO soldierUpdateDTO) throws ServiceException;
    
    final class SoldierUpdateDTO {
        
        @NotBlank private String id;
        @NotBlank private String type;
        @NotBlank private String description;
        
        
        // Getters and Setters
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

    }
    
}
