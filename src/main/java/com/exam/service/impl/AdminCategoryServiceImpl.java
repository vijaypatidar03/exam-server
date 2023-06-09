package com.exam.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.Category;
import com.exam.repo.AdminCategoryRepository;
import com.exam.service.AdminCategoryService;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

	@Autowired
	private AdminCategoryRepository adminCategoryRepository;

	
	//insert 
	@Override
	public Category addCategory(Category category) {
		return this.adminCategoryRepository.save(category);
	}

	//update 
	@Override
	public Category updateCategory(Category category) {
		return this.adminCategoryRepository.save(category);
	}

	//get all categories
	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<>(this.adminCategoryRepository.findAll());
	}

	//get one category
	@Override
	public Category getCategory(Long categoryId) {
		return this.adminCategoryRepository.findById(categoryId).get();
	}

	@Override
	public String deleteCategory(Long categoryId) {
		Category category = new Category();
		category.setCid(categoryId);
		this.adminCategoryRepository.delete(category);
		return "Deleted ";
	}
}
