package com.sprint.plant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.sprint.plant.datajparepo.PlantRepository;
import com.sprint.plant.model.Plant;
import com.sprint.plant.service.PlantService;

/**
 * @author Saiqua Aslam
 *
 */
@SpringBootTest
class PlantTestCases {
	@Autowired
	private PlantService service;

	/**
	 * testing service layer method to to add a plant
	 */

	@Test
	void testAddPlant() {
		Plant plant = service.addPlant(new Plant(9.0, "Hibiscus", "Skin Benefits", 22.0, 8, 330.0, "Shurbs"));
		assertEquals("Hibiscus", plant.getName());

	}

	/**
	 * testing service layer method to upadte plant
	 */
	@Test
	void testUpdatePlant() {
		Plant plant = service.updatePlant(new Plant( 8.0, "Lemon", "Antihairfall", 22.0, 5, 170.0, "shurb"));
		assertEquals(170.0, plant.getCost());
	}

	/**
	 * testing service layer method to delete plant using id
	 */
	@Test
	void testDeletePlant() {
		List<Plant> plant = service.deletePlant(50);
		assertFalse(plant.isEmpty());
	}

	/**
	 * testing service layer method to view plant using id
	 */
	@Test
	void testGetPlant() {
		Plant plant = service.getPlant(53);
		assertNotEquals("Rose", plant.getName());
	}

	/**
	 * testing service layer method to view all the plants present in database
	 *
	 */
	@Test
	void testgetAllPlants() {
		List<Plant> plantlist = service.getAllPlant();
		boolean result = true;
		if (plantlist.isEmpty()) {
			result = false;
		}
		assertTrue(result);
	}

	/**
	 * testing service layer method to view all the plants present in database using
	 * plant name
	 * 
	 */
	@Test
	void testGetAllByName() {
		List<Plant> plant = service.getAllByName("Tulsi");
		String name = plant.get(0).getName();
		assertEquals("Tulsi", name);
	}

	/**
	 * testing service layer method to view all the plants present in database using
	 * plant type
	 * 
	 */
	@Test
	void testGetAllByType() {
		List<Plant> plant = service.getAllByType("Shurbs");
		String type = plant.get(0).getType();
		assertEquals("Shurbs", type);
	}

}
