package com.sp.Assigment02.controller;


import com.sp.Assigment02.dto.CategoryDto;
import com.sp.Assigment02.response.Api_Response;
import com.sp.Assigment02.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CategoryController {



    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/getCategory")
    ResponseEntity<Api_Response<List<CategoryDto>>> getCategories(){

        return categoryService.getAllCategory();
    }



}
