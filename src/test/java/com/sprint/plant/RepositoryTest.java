package com.sprint.plant;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.plant.datajparepo.PlantRepository;
import com.sprint.plant.model.Plant;


/**
 * @author Saiqua Aslam
 *
 */
@SpringBootTest
public class RepositoryTest {
	@Autowired
	PlantRepository repository;
	/**
	 * testing repository layer method to view all the plants present in database using
	 * plant name
	 * 
	 */
	@Test
	void testGetAllByName() {
		List<Plant> plant = repository.findAllByName("Tulsi");
		String name = plant.get(0).getName();
		assertEquals("Tulsi", name);
	}

	/**
	 * testing repository layer method to view all the plants present in database using
	 * plant type
	 * 
	 */
	@Test
	void testGetAllByType() {
		List<Plant> plant = repository.findAllByType("Shurbs");
		String type = plant.get(0).getType();
		assertEquals("Shurbs", type);
	}
}
