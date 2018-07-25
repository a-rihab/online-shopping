package com.pearl.backendshopping.dao;

import java.util.List;

import com.pearl.backendshopping.dto.Category;

public interface CategoryDAO {
	
	
	
	List <Category> list();
	Category get(int id);
	boolean add(Category category);
	boolean upadte(Category category);
	boolean delete(Category category);
	
}
