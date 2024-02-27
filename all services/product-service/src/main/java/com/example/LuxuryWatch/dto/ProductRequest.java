package com.example.LuxuryWatch.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String model;
    private String manufacturer;
    private Float price;
    private Integer year;
    private String style;
    private Integer size;
    private String material;
    private String movement;
    private String picture;
}


