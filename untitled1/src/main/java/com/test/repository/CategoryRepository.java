package com.test.repository;

import com.test.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by user on 15.09.2015.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

	@Query(value = "SELECT c FROM Category c WHERE c.parentCategory = 0")
	List<Category> getMainCategories();

	@Query(value = "SELECT c FROM Category c WHERE c.parentCategory = :mainCategory")
	List<Category> getSubCategories(@Param("mainCategory") Integer idCategory);
}
