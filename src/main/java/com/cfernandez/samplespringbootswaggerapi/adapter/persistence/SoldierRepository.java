package com.cfernandez.samplespringbootswaggerapi.adapter.persistence;

import com.cfernandez.samplespringbootswaggerapi.model.Soldier;

import org.springframework.data.repository.CrudRepository;

public interface SoldierRepository extends CrudRepository<Soldier, Integer> {
}
