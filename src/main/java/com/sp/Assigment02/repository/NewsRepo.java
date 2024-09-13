package com.sp.Assigment02.repository;

import com.sp.Assigment02.Entity.CategoryEntity;
import com.sp.Assigment02.Entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NewsRepo extends JpaRepository<NewsEntity,Long> {

    Optional<List<NewsEntity>> findAllByCategory(CategoryEntity categoryEntity);
}
