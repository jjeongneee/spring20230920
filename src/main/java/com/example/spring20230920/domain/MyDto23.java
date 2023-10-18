package com.example.spring20230920.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MyDto23 {
    private LocalDate date;
    private String name;
    private String CategoryName;
    private Integer Quantity;
    private Double Price;
}
