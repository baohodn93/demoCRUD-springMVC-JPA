package com.springmvc.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.demo.models.Category;
import com.springmvc.demo.repositories.CategoryRepository;

@Controller
@RequestMapping(path = "categories")
//http:localhost:8080/categories
public class CategoryController {
	@Autowired //Inject "categoryRepository"- Dependency Injection
	private CategoryRepository categoryRepository;
	
	//return name of .jsp file
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAllCategories(ModelMap modelMap) {
		//data sent to jsp =>ModelMap
//		modelMap.addAttribute("name","Bao");
//		modelMap.addAttribute("age","29");
        Iterable<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
//        System.out.println("haha");
        return "category";
	}

}
