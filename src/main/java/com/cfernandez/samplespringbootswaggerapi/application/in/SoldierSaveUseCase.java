package com.cfernandez.samplespringbootswaggerapi.application.in;

import com.cfernandez.samplespringbootswaggerapi.application.exception.ServiceException;
import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;

import javax.validation.constraints.NotBlank;

public interface SoldierSaveUseCase {

    /**
     * Method that has the logic for save a new Soldier
     * @param soldierSaveDTO Soldier
     * @return SoldierEntity
     */
    SoldierEntity save(SoldierSaveDTO soldierSaveDTO) throws ServiceException;

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
        
        
        // Getters and Setters
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCombatPower() {
			return combatPower;
		}
		public void setCombatPower(String combatPower) {
			this.combatPower = combatPower;
		}
		public String getStrengthSoldierMeeting() {
			return strengthSoldierMeeting;
		}
		public void setStrengthSoldierMeeting(String strengthSoldierMeeting) {
			this.strengthSoldierMeeting = strengthSoldierMeeting;
		}
		public String getStrengthDistanceSoldiers() {
			return strengthDistanceSoldiers;
		}
		public void setStrengthDistanceSoldiers(String strengthDistanceSoldiers) {
			this.strengthDistanceSoldiers = strengthDistanceSoldiers;
		}
		public String getLootingCapacity() {
			return lootingCapacity;
		}
		public void setLootingCapacity(String lootingCapacity) {
			this.lootingCapacity = lootingCapacity;
		}
		public String getTravelVelocity() {
			return travelVelocity;
		}
		public void setTravelVelocity(String travelVelocity) {
			this.travelVelocity = travelVelocity;
		}
		public String getFood() {
			return food;
		}
		public void setFood(String food) {
			this.food = food;
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
