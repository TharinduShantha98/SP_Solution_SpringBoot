package com.sp.Assigment02.controller;


import com.sp.Assigment02.dto.CategoryDto;
import com.sp.Assigment02.dto.NewsDto;
import com.sp.Assigment02.dto.NewsRequestDto;
import com.sp.Assigment02.response.Api_Response;
import com.sp.Assigment02.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NewsController {


    private final NewsService newsService;


    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    @GetMapping("/getNewsUsingCategory")
    ResponseEntity<Api_Response<List<NewsDto>>> getNewsUsingCategory(@RequestBody NewsRequestDto newsRequestDto){
        return newsService.getNewsUsingCategory(newsRequestDto);
    }
}
