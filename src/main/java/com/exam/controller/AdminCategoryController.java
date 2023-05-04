package com.exam.controller;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Category;
import com.exam.service.AdminCategoryService;

@RestController
@RequestMapping("/admin/category")
@CrossOrigin("*")
public class AdminCategoryController {

	@Autowired
	private AdminCategoryService adminCategoryService;
	
	//insert category
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
	this.adminCategoryService.addCategory(category);
	return ResponseEntity.ok("Post Success");
	}
	
	//get one category
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		return this.adminCategoryService.getCategory(categoryId);
	}
	
	//get all category
	@GetMapping("/")
	public Set<Category> getCategories()
	{
		return this.adminCategoryService.getCategories();
	}
	
	//update category
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return this.adminCategoryService.updateCategory(category);
	}
	
	//delete category
	@DeleteMapping("/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") Long categoryId)
	{
		this.adminCategoryService.deleteCategory(categoryId);
		return " Deleted : "+categoryId;
	}
}
