package com.cfernandez.samplespringbootswaggerapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOLDIERS")
public class SoldierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "NAME")
    private String name;

    @Column(name = "COMBAT_POWER")
    private Integer combatPower;

    @Column(name = "STRENGTH_SOLDIER_MEETING")
    private Integer strengthSoldierMeeting;

    @Column(name = "STRENGTH_DISTANCE_SOLDIERS")
    private Integer strengthDistanceSoldiers;

    @Column(name = "LOOTING_CAPACITY")
    private Integer lootingCapacity;

    @Column(name = "TRAVEL_VELOCITY")
    private Integer travelVelocity;

    @Column(name = "FOOD")
    private Integer food;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DESCRIPTION")
    private String description;
    
    
    // Getters and Setters
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCombatPower(Integer combatPower) {
		this.combatPower = combatPower;
	}

	public void setStrengthSoldierMeeting(Integer strengthSoldierMeeting) {
		this.strengthSoldierMeeting = strengthSoldierMeeting;
	}

	public void setStrengthDistanceSoldiers(Integer strengthDistanceSoldiers) {
		this.strengthDistanceSoldiers = strengthDistanceSoldiers;
	}

	public void setLootingCapacity(Integer lootingCapacity) {
		this.lootingCapacity = lootingCapacity;
	}

	public void setTravelVelocity(Integer travelVelocity) {
		this.travelVelocity = travelVelocity;
	}

	public void setFood(Integer food) {
		this.food = food;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getCombatPower() {
		return combatPower;
	}

	public Integer getStrengthSoldierMeeting() {
		return strengthSoldierMeeting;
	}

	public Integer getStrengthDistanceSoldiers() {
		return strengthDistanceSoldiers;
	}

	public Integer getLootingCapacity() {
		return lootingCapacity;
	}

	public Integer getTravelVelocity() {
		return travelVelocity;
	}

	public Integer getFood() {
		return food;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}
    
}
