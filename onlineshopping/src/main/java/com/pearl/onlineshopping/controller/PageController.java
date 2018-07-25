package com.pearl.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pearl.backendshopping.dao.CategoryDAO;
import com.pearl.backendshopping.dao.ProductDAO;
import com.pearl.backendshopping.dto.Category;
import com.pearl.backendshopping.dto.Product;
import com.pearl.onlineshopping.exception.ProductNotFoundException;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mView = new ModelAndView("page");

		mView.addObject("title", "Home");
		mView.addObject("categories", categoryDAO.list());
		mView.addObject("userClickHome", true);

		return mView;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mView = new ModelAndView("page");

		mView.addObject("title", "About us");
		mView.addObject("userClickAbout", true);

		return mView;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView mView = new ModelAndView("page");

		mView.addObject("title", "Contact us");
		mView.addObject("userClickContact", true);

		return mView;
	}

	/*
	 * methods to load all the products and based on category
	 */

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {

		ModelAndView mView = new ModelAndView("page");

		mView.addObject("title", "All Products");
		mView.addObject("categories", categoryDAO.list());
		mView.addObject("userClickAllProducts", true);

		return mView;
	}

	@RequestMapping(value = "/show/category/{id}/products") 
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){

		ModelAndView mView = new ModelAndView("page");

		// categoryDAO ti fetch a single category
		Category category = null;

		category = categoryDAO.get(id);

		mView.addObject("title", category.getName());
		mView.addObject("categories", categoryDAO.list());
		mView.addObject("category", category);
		mView.addObject("userClickCategoryProducts", true);

		return mView;
	}

	@RequestMapping("/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id)throws ProductNotFoundException  {

		ModelAndView mView = new ModelAndView("page");

		Product product = productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException();

		product.setViews(product.getViews() + 1);

		productDAO.update(product);

		mView.addObject("title", product.getName());
		mView.addObject("product", product);
		mView.addObject("userClickShowProduct", true);

		return mView;

	}
}
