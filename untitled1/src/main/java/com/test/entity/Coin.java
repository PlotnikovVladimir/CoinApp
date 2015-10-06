package com.test.entity;

import javax.persistence.*;
import java.io.*;

/**
 * Created by user on 11.09.2015.
 */
@Entity
@Table(name = "COIN")
public class Coin implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "COIN_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "YEAR")
	private int year;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne
	@JoinColumn(name = "CATEGORY")
	private Category category;

	public Coin() {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
