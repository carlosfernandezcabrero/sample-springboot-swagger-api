package com.cfernandez.samplespringbootswaggerapi.application.in;

import com.cfernandez.samplespringbootswaggerapi.application.exception.ServiceException;
import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public interface SoldierSaveUseCase {

    /**
     * Method that has the logic for save a new Soldier
     * @param soldierSaveDTO Soldier
     * @return SoldierEntity
     */
    SoldierEntity save(SoldierSaveDTO soldierSaveDTO) throws ServiceException;

    @Getter
    @Setter
    final class SoldierSaveDTO {

        @NotBlank private String name;
        @NotBlank private String combatPower;
        @NotBlank private String strengthSoldierMeeting;
        @NotBlank private String strengthDistanceSoldiers;
        @NotBlank private String lootingCapacity;
        @NotBlank private String travelVelocity;
        @NotBlank private String food;
        private String type = "N/A";
        private String description = "Without description";

    }
}
