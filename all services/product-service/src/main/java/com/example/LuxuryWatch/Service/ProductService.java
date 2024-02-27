package com.example.LuxuryWatch.Service;

import com.example.LuxuryWatch.Beam.Product;
import com.example.LuxuryWatch.Dao.ProductDao;
import com.example.LuxuryWatch.dto.ProductRequest;
import com.example.LuxuryWatch.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product createProduct(ProductRequest productRequest) {

        Product product = new Product();
        product.setModel(productRequest.getModel());
        product.setManufacturer(productRequest.getManufacturer());
        product.setPrice(productRequest.getPrice());
        product.setYear(productRequest.getYear());
        product.setStyle(productRequest.getStyle());
        product.setSize(productRequest.getSize());
        product.setMaterial(productRequest.getMaterial());
        product.setMovement(productRequest.getMovement());
        product.setPicture(productRequest.getPicture());

        productDao.save(product);
        System.out.println("Product: " + product.getId());
        return product;
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productDao.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .model(product.getModel())
                .manufacturer(product.getManufacturer())
                .price(product.getPrice())
                .year(product.getYear())
                .style(product.getStyle())
                .size(product.getSize())
                .material(product.getMaterial())
                .movement(product.getMovement())
                .picture(product.getPicture())
                .build();
    }

}
