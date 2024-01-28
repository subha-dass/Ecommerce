package com.Ecommerce.Ecommerce.controller;

import com.Ecommerce.Ecommerce.Entity.Product;
import com.Ecommerce.Ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/abc")
    public String getABC(){
        return "ac";
    }
    @PostMapping("/addProduct")
    public ResponseEntity<Object> addProduct(
            @RequestParam("name") String name,
            @RequestParam("category") String category,
            @RequestParam("product_quantity") int productQuantity,
            @RequestParam("product_ratings") int productRatings,
            @RequestParam("product_price") double productPrice,
            @RequestParam("image") MultipartFile file) throws IOException {

        // Validate the incoming product object
//        if (bindingResult.hasErrors()) {
//            // If validation fails, return the validation errors in the response
//            return ResponseEntity.badRequest().body(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
//        }

        // Try to save the product
        Product savedProduct = service.saveProduct(name, category, productQuantity, productRatings, productPrice, file);

        // Check if the saving process was successful
        if (savedProduct != null) {
            // Return the saved product in the response
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } else {
            // If saving failed, return an appropriate response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the product.");
        }
    }


    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductByID(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

}
