package com.cfernandez.samplespringbootswaggerapi.adapter.persistence;

import com.cfernandez.samplespringbootswaggerapi.model.SoldierEntity;

import org.springframework.data.repository.CrudRepository;

public interface SoldierRepository extends CrudRepository<SoldierEntity, Integer> {
}
