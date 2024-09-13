package com.sp.Assigment02.dto;

import com.sp.Assigment02.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private Date createDate;
    private Date updateDate;
    private Status status;
}
