package com.example.product.productmicroservice.DTO;

import java.io.Serializable;
import java.util.List;

public class ProductDTO implements Serializable {
    private int id;
    private String name;
    private String description;
    private Long price;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, String description, Long price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
