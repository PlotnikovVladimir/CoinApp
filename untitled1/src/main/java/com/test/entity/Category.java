package com.test.entity;

import javax.persistence.*;
import java.io.*;
import java.util.*;

/**
 * Created by user on 11.09.2015.
 */
@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PARENT")
	private int parentCategory;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<Coin> coins;

	public Category() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(int parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<Coin> getCoins() {
		return coins;
	}

	public void setCoins(List<Coin> coins) {
		this.coins = coins;
	}
}
