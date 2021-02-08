package com.sprint.plant.service;

import java.util.List;

import com.sprint.plant.model.Plant;

/**
 * @author Saiqua Aslam
 *
 */
public interface IPlantService {
	Plant addPlant(Plant plant);// to add a plant

	Plant updatePlant(Plant plant);// to upadte plant

	List<Plant> deletePlant(int id);// to delete plant using id

	Plant getPlant(int id);// to view plant using id

	List<Plant> getAllPlant();// to view all the plants present in database

	List<Plant> getAllByName(String name);// to view plants using name

	List<Plant> getAllByType(String type);// to view plants using tyoe
}
