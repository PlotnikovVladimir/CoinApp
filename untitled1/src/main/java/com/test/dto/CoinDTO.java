package com.test.dto;

/**
 * Created by user on 15.09.2015.
 */
public class CoinDTO {
	private Integer id;
	private String name;
	private int year;
	private String description;
	private int category;

	public CoinDTO() {
	}

	public CoinDTO(String name, int year, String description, int category) {
		this.name = name;
		this.year = year;
		this.description = description;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
}
