package com.test.services;

import com.test.entity.*;

import java.util.*;

/**
 * Created by user on 14.09.2015.
 */
public interface CoinService {
	List<Coin> getAllCoins();
	Coin getCoinById(int id);
}
