package com.test.repository;

import com.test.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;

/**
 * Created by user on 25.09.2015.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(value = "SELECT u FROM User u WHERE u.login = :userLogin")
	User getUserByLogin(@Param("userLogin") String userLogin);

}
