package com.sp.Assigment02.repository;

import com.sp.Assigment02.Entity.CategoryEntity;
import com.sp.Assigment02.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo extends JpaRepository<CategoryEntity,Long> {

    Optional<List<CategoryEntity>> findAllByStatus(Status status);

}
