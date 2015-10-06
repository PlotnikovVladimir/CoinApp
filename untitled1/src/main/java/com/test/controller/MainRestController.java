package com.test.controller;

import com.google.gson.*;
import com.test.dto.*;
import com.test.entity.*;
import com.test.manager.GoogleResults;
import com.test.services.impl.*;
import ma.glasnost.orika.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.*;
import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;


@RequestMapping("/api/v1")
@RestController
public class MainRestController{

	@Autowired
	private CoinServiceImpl coinService;
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	private UserServiceImpl userService;

	@Autowired
	MapperFacade mapper;

	@RequestMapping(value = "/coins", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<CoinDTO> getAllCoins() {
		return mapper.mapAsList(coinService.getAllCoins(), CoinDTO.class);
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<CategoryDTO> getCategories() {
		return mapper.mapAsList(categoryService.getAll(), CategoryDTO.class);
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<CategoryDTO> getSubCategories(@PathVariable Integer id) {
		return mapper.mapAsList(categoryService.getSubCategories(id), CategoryDTO.class);
	}

	@RequestMapping(value = "/categories/{id}/coins", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<CoinDTO> getCoinsByMainCategory(@PathVariable Integer id) {
		return mapper.mapAsList(coinService.getCoinsByMainCategory(id), CoinDTO.class);
	}

	@RequestMapping(value = "/categories/{id}/coins", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void newCoin(@PathVariable Integer id,
	                      @RequestBody CoinRequest jsonString,
	                      HttpServletRequest request) {

		coinService.createNewCoin(id, jsonString, request);
	}

	@RequestMapping(value = "/categories/{idCategory}/coins/{idCoin}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void editCoin(@PathVariable Integer idCategory,
	                       @PathVariable Integer idCoin,
	                       @RequestBody CoinRequest jsonString,
	                       HttpServletRequest request) {

		coinService.editCoinsData(idCoin, idCategory, jsonString, request);
	}

	@RequestMapping(value = "/coins/{idCoin}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteCoin(@PathVariable Integer idCoin,
	                         HttpServletRequest request) {

		coinService.deleteCoinAndImage(idCoin, request);
	}

	@RequestMapping(value = "/generateCoinsImage/{idCoin}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public GoogleResults generateImage(@PathVariable Integer idCoin) throws IOException {
		Coin coin = coinService.getCoinById(idCoin);
		if (null != coin) {
			String address = "http://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=";
			String query = coin.getName() + " " + coin.getYear();
			String charset = "UTF-8";

			URL url = new URL(address + URLEncoder.encode(query, charset));
			Reader reader = new InputStreamReader(url.openStream(), charset);
			return new Gson().fromJson(reader, GoogleResults.class);
		}
		return null;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public UserDTO getCurrentUser(Principal principal){
		if (null != principal) {
			User user = userService.getUserByLogin(principal.getName());
			if (null != user) {
				return mapper.map(user, UserDTO.class);
			}
		}
		return null;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void newUser(@RequestBody UserDTO userDTO){
		userService.createUser(userDTO);
	}


}

