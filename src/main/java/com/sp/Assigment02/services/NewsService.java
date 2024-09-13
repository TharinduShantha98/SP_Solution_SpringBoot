package com.sp.Assigment02.services;

import com.sp.Assigment02.dto.CategoryDto;
import com.sp.Assigment02.dto.NewsDto;
import com.sp.Assigment02.dto.NewsRequestDto;
import com.sp.Assigment02.response.Api_Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NewsService {

    ResponseEntity<Api_Response<List<NewsDto>>> getNewsUsingCategory(NewsRequestDto newsRequestDto);
}
