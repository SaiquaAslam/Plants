package com.sprint.plant.exception;

/**
 * @author Saiqua Aslam
 *
 */

//customise exception class
public class PlantNotFoundException extends RuntimeException {

	public PlantNotFoundException() {
		
	}

	public PlantNotFoundException(String message) {
		super(message);
	}
}