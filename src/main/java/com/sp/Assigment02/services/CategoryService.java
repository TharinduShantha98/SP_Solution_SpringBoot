package com.sp.Assigment02.services;

import com.sp.Assigment02.dto.CategoryDto;
import com.sp.Assigment02.response.Api_Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    ResponseEntity<Api_Response<List<CategoryDto>>> getAllCategory();
}
