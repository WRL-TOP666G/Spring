package com.example.LuxuryWatch.Beam;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.function.RenderingResponse;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LW_PRODUCT")
public class Product {
    @Id
    @SequenceGenerator(name = "lw_product_seq_gen", sequenceName = "LW_PRODUCT_SEQ", allocationSize = 1)
    @GeneratedValue(generator="lw_product_seq_gen", strategy = GenerationType.AUTO)
    private int id;

    private String model;
    private String manufacturer;
    private Float price;
    private Integer year;
    private String style;
    private Integer size;
    private String material;
    private String movement;
    private String picture;


//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "product")
//    private Set<Review> reviews;

}
