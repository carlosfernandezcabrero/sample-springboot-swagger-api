package com.cfernandez.samplespringbootswaggerapi.application.in;

public interface SoldierDeleteByIdUseCase {

	/**
	 * Method that has the logic for delete a Soldier by his ID
	 * @param id ID
	 */
	void deleteById(Integer id);

}
