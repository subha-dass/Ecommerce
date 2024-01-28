package com.Ecommerce.Ecommerce.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {
    @Id
    @GeneratedValue
    private int id;
    @Size(min= 3 , message = "Enter atleast 3 characters")
    private String name;
    @Size(min= 3 , message = "Enter atleast 3 characters")
    private String category;
    @NotNull(message = "Product quantity must not be null")
    @Min(value = 0, message = "Product quantity must be greater than or equal to 0")
    private int product_quantity;
    @NotNull(message = "Product ratings must not be null")
    @Min(value = 0, message = "Product ratings must be greater than or equal to 0")
    private int product_ratings;
    @NotNull(message = "Product price must not be null")
    @Min(value = 1, message = "Product price must be greater than or equal to 1")
    private double product_price;
    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;
}
