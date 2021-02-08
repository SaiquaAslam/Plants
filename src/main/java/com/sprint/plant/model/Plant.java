package com.sprint.plant.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Saiqua Aslam
 *
 */
@Entity
@Table(name = "plant_details")
public class Plant implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "plant_id")
	private Integer plantId;

	@Column(name = "plant_name")
	@NotEmpty(message = "Name should not be empty!!!")
     @Size(min = 4, message = "min 4 chars required")
	@NotNull(message = "Name should not be null. please provide a value")
	private String name;

	@Column(name = "plant_height")
	@NotNull(message = "Height should not be null")
	private Double plantHeight;

	@Column(name = "medicinal_use")
	@NotEmpty(message = "Please provide a valid medicinal use")
	private String medicinalUse;

	@Column(name = "suitable_temperatue")
	@NotNull(message = "Suitable temperature must be provided")
	private Double temperature;

	@Column(name = "plant_stock")
	@NotNull(message = "Stock should not be null provide 0 if no plant is present")
	private int plantStock;

	@Column(name = "plant_cost")
	@NotNull(message = "Cost should not be null...")
	private Double cost;

	@Column(name = "plant_type")
	@NotEmpty(message = "Type should not be empty!!!")
    private String type;
	
	public Plant() {

	}

	public Plant(Double plantHeight, String name, String medicinalUse, Double temperature, Integer plantStock,
			Double cost, String type) {
		super();
		this.plantHeight = plantHeight;
		this.name = name;
		this.medicinalUse = medicinalUse;
		this.temperature = temperature;
		this.plantStock = plantStock;
		this.cost = cost;
		this.type=type;
	}

	

	/**
	 * @return the plantId
	 */
	public Integer getPlantId() {
		return plantId;
	}

	/**
	 * @param plantid the plantId to set
	 */
	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	/**
	 * @return the plantHeight
	 */
	public Double getPlantHeight() {
		return plantHeight;
	}

	/**
	 * @param plantheight the plantHeight to set
	 */
	public void setPlantHeight(Double plantHeight) {
		this.plantHeight = plantHeight;
	}

	/**
	 * @return the commonName
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param commonName the commonName to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the medicinalUse
	 */
	public String getMedicinalUse() {
		return medicinalUse;
	}

	/**
	 * @param medicinaluse the medicinalUse to set
	 */
	public void setMedicinalUse(String medicinalUse) {
		this.medicinalUse = medicinalUse;
	}

	/**
	 * @return the temperature
	 */
	public Double getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the plantStock
	 */
	public Integer getPlantStock() {
		return plantStock;
	}

	/**
	 * @param plantStock the plantStock to set
	 */
	public void setPlantStock(Integer plantStock) {
		this.plantStock = plantStock;
	}

	/**
	 * @return the cost
	 */
	public Double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}
	


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Plant [plantId=" + plantId + ", name=" + name + ", plantHeight=" + plantHeight + ", medicinalUse="
				+ medicinalUse + ", temperature=" + temperature + ", plantStock=" + plantStock + ", cost=" + cost
				+ ", type=" + type + "]";
	}
	
}
