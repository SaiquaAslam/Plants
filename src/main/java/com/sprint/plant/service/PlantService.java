package com.sprint.plant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint.plant.datajparepo.PlantRepository;
import com.sprint.plant.model.Plant;

/**
 * @author Saiqua Aslam
 *
 */

@Service
@Transactional
public class PlantService implements IPlantService {
	@Autowired
	PlantRepository repository;

	/**
	 * calling repository predefine layer method to to add a plant
	 */

	@Override
	public Plant addPlant(Plant plant) {
		return repository.save(plant);
	}

	/**
	 * calling repository layer predefine method to upadte plant
	 */
	@Override
	public Plant updatePlant(Plant plant) {
		return repository.save(plant);
	}

	/**
	 * calling repository layer predefine method to delete plant using id
	 */
	@Override
	public List<Plant> deletePlant(int id) {
		repository.deleteById(id);
		return repository.findAll();
	}

	/**
	 * calling repository predefine layer method to view plant using id
	 */
	@Override
	public Plant getPlant(int id) {
		return repository.findById(id).orElse(null);
	}

	/**
	 * calling repository layer predefine method to view all the plants present in
	 * database
	 */
	@Override
	public List<Plant> getAllPlant() {
		return repository.findAll();
	}

	/**
	 * calling repository layer customise method to view plant using name
	 * 
	 */
	@Override
	public List<Plant> getAllByName(String name) {
		return repository.findAllByName(name);

	}

	/**
	 * calling repository layer customise method to view plant using type
	 * 
	 */
	@Override
	public List<Plant> getAllByType(String type) {
		return repository.findAllByType(type);

	}
}
