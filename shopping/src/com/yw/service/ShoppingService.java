package com.yw.service;

import java.util.List;

import com.yw.model.Shopping;

public interface ShoppingService {
	boolean addShopping(Shopping s);
	List<Shopping> showAll();
}
