package com.sp.Assigment02.services.impl;

import com.sp.Assigment02.Entity.CategoryEntity;
import com.sp.Assigment02.Entity.NewsEntity;
import com.sp.Assigment02.dto.NewsDto;
import com.sp.Assigment02.dto.NewsRequestDto;
import com.sp.Assigment02.repository.CategoryRepo;
import com.sp.Assigment02.repository.NewsRepo;
import com.sp.Assigment02.response.Api_Response;
import com.sp.Assigment02.services.NewsService;
import com.sp.Assigment02.util.ResponseCode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    private final CategoryRepo categoryRepo;
    private final NewsRepo newsRepo;

    private final ModelMapper modelMapper;

    @Autowired
    public NewsServiceImpl(CategoryRepo categoryRepo, NewsRepo newsRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.newsRepo = newsRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<Api_Response<List<NewsDto>>> getNewsUsingCategory(NewsRequestDto newsRequestDto) {

        Optional<CategoryEntity> byId = categoryRepo.findById(newsRequestDto.getId());
        if(byId.isEmpty()){
            return  new ResponseEntity<>(new Api_Response<>(ResponseCode.failed, "Category not found ", null), HttpStatus.NOT_FOUND);
        }
        CategoryEntity categoryEntity = byId.get();
        Optional<List<NewsEntity>> allByCategory = newsRepo.findAllByCategory(categoryEntity);
        if(allByCategory.isEmpty()){
            return  new ResponseEntity<>(new Api_Response<>(ResponseCode.failed, "category not found this Id "+ newsRequestDto.getId(), null), HttpStatus.OK);
        }

        List<NewsEntity> newsEntities = allByCategory.get();
        List<NewsDto> list = newsEntities.stream().map(newsEntity -> {
            return modelMapper.map(newsEntity, NewsDto.class);
        }).toList();

         return  new ResponseEntity<>(new Api_Response<>(ResponseCode.success, "Success ", list), HttpStatus.OK);
    }
}
