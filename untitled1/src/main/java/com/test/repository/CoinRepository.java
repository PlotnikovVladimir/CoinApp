package com.test.repository;

import com.test.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Repository
public interface CoinRepository extends CrudRepository<Coin, Integer> {
	@Query(value = "SELECT co FROM Coin co WHERE co.category IN :Categories")
	List<Coin> getCoinsByCategory(@Param("Categories") List<Category> categoryList);
}
