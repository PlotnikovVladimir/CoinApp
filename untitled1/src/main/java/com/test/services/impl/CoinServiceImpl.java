package com.test.services.impl;

import com.test.dto.*;
import com.test.entity.*;
import com.test.manager.*;
import com.test.repository.*;
import com.test.services.*;
import ma.glasnost.orika.*;
import org.apache.commons.codec.binary.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.Base64;

/**
 * Created by user on 14.09.2015.
 */
@Service
public class CoinServiceImpl implements CoinService {

	@Autowired
	private CoinRepository coinRepository;
	@Autowired
	private CategoryServiceImpl categoryService;
	@Autowired
	MapperFacade mapper;


	public List<Coin> getAllCoins(){
		return (List<Coin>) coinRepository.findAll();
	}

	public Coin getCoinById(int id) {
		return coinRepository.findOne(id);
	}

	public List<Coin> getCoinsByCategories(List<Category> categoryList){

		return coinRepository.getCoinsByCategory(categoryList);
	}

	public void saveCoin(Coin coin){
		coinRepository.save(coin);
	}

	public void deleteCoin(int id) {
		coinRepository.delete(id);
	}

	public List<Coin> getCoinsByMainCategory(int idCategory){
		List<Category> categoriesList = categoryService.getSubCategories(idCategory);
		categoriesList.add(categoryService.getCategoryById(idCategory));
		return getCoinsByCategories(categoriesList);
	}

	public void createNewCoin(int idCategory, CoinRequest jsonString, HttpServletRequest request){
		CoinDTO coinDTO = mapper.map(jsonString, CoinDTO.class);
		coinDTO.setCategory(idCategory);
		Coin coin = mapper.map(coinDTO, Coin.class);
		saveCoin(coin);
		System.out.println("create coin, id =  " + coin.getId());
		//TODO create enum for coinsSide
		ImageManager.getInstance().saveCoinsImage(coin.getId(), "a", jsonString.getImageAversStr(), request);
		ImageManager.getInstance().saveCoinsImage(coin.getId(), "r", jsonString.getImageReversStr(), request);
	}

	public void editCoinsData(int idCoin, int idCategory, CoinRequest jsonString, HttpServletRequest request){
		Coin coin = getCoinById(idCoin);

		if (!coin.getCategory().equals(categoryService.getCategoryById(idCategory))){
			coin.setCategory(categoryService.getCategoryById(idCategory));
		}
		if (!coin.getName().equals(jsonString.getName())) {
			coin.setName(jsonString.getName());
		}
		if (!coin.getDescription().equals(jsonString.getDescription())) {
			coin.setDescription(jsonString.getDescription());
		}
		if (coin.getYear() != jsonString.getYear()) {
			coin.setYear(jsonString.getYear());
		}
		saveCoin(coin);

		if (null != jsonString.getImageAversStr()) {
			ImageManager.getInstance().editCoinsImage(idCoin, "a", jsonString.getImageAversStr(), request);
		}
		if (null != jsonString.getImageReversStr()) {
			ImageManager.getInstance().editCoinsImage(idCoin, "r", jsonString.getImageReversStr(), request);
		}
	}

	public void deleteCoinAndImage(int idCoin, HttpServletRequest request) {
		ImageManager.getInstance().deleteCoinsImage(idCoin, "a",request);
		ImageManager.getInstance().deleteCoinsImage(idCoin, "r",request);
		coinRepository.delete(idCoin);
	}

}
