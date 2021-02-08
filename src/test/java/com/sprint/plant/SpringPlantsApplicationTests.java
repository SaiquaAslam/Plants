package com.sprint.plant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.plant.controller.PlantController;
import com.sprint.plant.datajparepo.PlantRepository;
import com.sprint.plant.model.Plant;
import com.sprint.plant.service.PlantService;

/**
 * @author Saiqua Aslam
 *
 */
@SpringBootTest
class SpringPlantsApplicationTests {
	@Autowired
	private PlantController controller;

	/**
	 * mehtod for testing the controller
	 */
	@Test
	void contextLoads() {
		boolean result=true;
		if(controller.equals(null)) {
		result =false;
		}
		assertTrue(result);
	}
	
	

}
