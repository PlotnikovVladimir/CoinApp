package com.test.services.impl;

import com.test.dto.*;
import com.test.entity.*;
import com.test.entity.User;
import com.test.repository.*;
import ma.glasnost.orika.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Created by user on 25.09.2015.
 */
@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	MapperFacade mapper;

	public void saveUser(User user){
		userRepository.save(user);
	}

	public User getUserByLogin(String userLogin) {
		return userRepository.getUserByLogin(userLogin);
	}

	public void createUser(UserDTO userDTO) {
		userDTO.setRole("ROLE_USER");
		userDTO.setDisable(true);
		User user = mapper.map(userDTO, User.class);
		saveUser(user);
		System.out.println("create user, id =  " + user.getId());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByLogin(username);
//		for (User user : userRepository.findAll()){
			if ((null != user) &&(user.getLogin().equals(username))){
				String password = user.getPassword();
				Set<String> roles = new HashSet<String>();
				roles.add(user.getRole());
				return new org.springframework.security.core.userdetails.User(username, password, toGrantedAuthorities(roles));
			}
//		}
		throw new UsernameNotFoundException("User was not found");
	}

	public List<GrantedAuthority> toGrantedAuthorities(Collection<String> roles){
		ArrayList<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		if (roles != null) {
			for (    String roleName : roles) {
				authorities.add(new SimpleGrantedAuthority(roleName));
			}
		}
		return authorities;
	}
}
