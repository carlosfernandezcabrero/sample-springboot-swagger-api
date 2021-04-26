package com.cfernandez.samplespringbootswaggerapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SOLDIERS")
public class Soldier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
}
