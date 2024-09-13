package com.sp.Assigment02.services.impl;

import com.sp.Assigment02.Entity.CategoryEntity;
import com.sp.Assigment02.dto.CategoryDto;
import com.sp.Assigment02.enums.Status;
import com.sp.Assigment02.repository.CategoryRepo;
import com.sp.Assigment02.response.Api_Response;
import com.sp.Assigment02.services.CategoryService;
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
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public ResponseEntity<Api_Response<List<CategoryDto>>> getAllCategory() {

        Optional<List<CategoryEntity>> byAllStatus = categoryRepo.findAllByStatus(Status.ACTIVE);

        if(byAllStatus.isEmpty()){
            return  new ResponseEntity<>(new Api_Response<>(ResponseCode.success, "Empty of category", null), HttpStatus.OK);
        }
        List<CategoryEntity> categoryEntities = byAllStatus.get();

        List<CategoryDto> list = categoryEntities.stream().map(categoryEntity -> {
            return modelMapper.map(categoryEntity, CategoryDto.class);
        }).toList();
        return  new ResponseEntity<>(new Api_Response<>(ResponseCode.success, "Get All Success ", list), HttpStatus.OK);
    }
}
