package com.sprint.plant.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.plant.exception.PlantNotFoundException;
import com.sprint.plant.model.Plant;
import com.sprint.plant.service.IPlantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Saiqua Aslam
 *
 */
@Api(value="Controller",description="Handler Methods Related To Plants Module!!!!")
@RestController
@RequestMapping("/api")
public class PlantController {

	@Autowired
	IPlantService service;

	/**
	 * calling service layer method to to add a plant
	 */
	@ApiOperation(value="Click here to Add a new plant !!!")
	@PostMapping("/addPlant")
	public Plant addPlant(@Valid @RequestBody Plant plant) {
		return service.addPlant(plant);
		
	}

	/**
	 * calling service layer method to upadte plant
	 */
	@ApiOperation(value="Click here to Update a plant !!!")
	@PutMapping("/updatePlant")
	public ResponseEntity<Plant> updatePlant(@Valid @RequestBody Plant plant)  {
			Plant plantInfo = service.updatePlant(plant);
				return new ResponseEntity<>(plantInfo, HttpStatus.OK);

			
		}

	

	/**
	 * calling service layer method to delete plant using id
	 */
	@ApiOperation(value="Click here to Delete a plant here by using plant id!!!")
	@DeleteMapping("/deletePlant/{id}")
	public ResponseEntity<List<Plant>> deletePlant(@PathVariable int id) {
		List<Plant> plants = service.deletePlant(id);
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}

	/**
	 * calling service layer method to view plant using id
	 */
	@ApiOperation(value="Click here to View a plant by using plant id!!!")
	@GetMapping("/getPlant/{id}")
	public ResponseEntity<Plant> getPlant(@PathVariable("id") int id) {

		Plant plant = service.getPlant(id);
		if (plant == null) {
			throw new PlantNotFoundException("No Plant present with the given id: " + id);
		}
		return new ResponseEntity<>(plant, HttpStatus.OK);
	}

	/**
	 * calling service layer method to view all the plants present in database
	 */
	@ApiOperation(value="Click here to View all plants present in database !!!")
	@GetMapping("/getAllPlants")
	public ResponseEntity<List<Plant>> getAllPlants()  {
		List<Plant> plants = service.getAllPlant();
		if (plants.isEmpty()) {
			throw new PlantNotFoundException("We have no plants now, please visit later!!!!!");
		} 
			return new ResponseEntity<>(plants, HttpStatus.OK);
	}

	/**
	 * calling service layer method to view all the plants present in database using
	 * plant name
	 */
	@ApiOperation(value="Click here to View all plants present in database by using the plant name !!!")
	@GetMapping("/getPlantsByName/{name}")
	public ResponseEntity<List<Plant>> getPlantsByName(@PathVariable String name)  {
		List<Plant> plants = service.getAllByName(name);
		
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}

	/**
	 * calling service layer method to view all the plants present in database using
	 * plant type
	 */
	@ApiOperation(value="Click here to View all plants present in database by using the plant type !!!")
	@GetMapping("/getPlantsByType/{type}")
	public ResponseEntity<List<Plant>> getPlantsByType(@PathVariable String type) {
		List<Plant> plants = service.getAllByType(type);
		if (plants.isEmpty()) {
			throw new PlantNotFoundException("No Plant present with the given type  " + type);
		}
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}

}
