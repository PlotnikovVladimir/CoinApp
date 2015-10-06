package com.test.dto;

import ma.glasnost.orika.*;
import ma.glasnost.orika.metadata.*;

/**
 * Created by user on 18.09.2015.
 */
public class CoinRequest {
	private String name;
	private int year;
	private String description;
	private String imageAversStr;
	private String imageReversStr;

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

	public String getImageAversStr() {
		return imageAversStr;
	}

	public void setImageAversStr(String imageAversStr) {
		this.imageAversStr = imageAversStr;
	}

	public String getImageReversStr() {
		return imageReversStr;
	}

	public void setImageReversStr(String imageReversStr) {
		this.imageReversStr = imageReversStr;
	}
}
