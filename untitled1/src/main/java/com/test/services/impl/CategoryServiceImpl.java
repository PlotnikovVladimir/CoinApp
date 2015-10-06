package com.test.services.impl;

import com.test.entity.*;
import com.test.repository.*;
import com.test.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.persistence.*;
import java.util.*;

/**
 * Created by user on 15.09.2015.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	public List<Category> getMainCategories() {
		return categoryRepository.getMainCategories();
	}

	public List<Category> getSubCategories(Integer id){
		return categoryRepository.getSubCategories(id);
	}

	public Category getCategoryById(Integer id){
		return categoryRepository.findOne(id);
	}

}
