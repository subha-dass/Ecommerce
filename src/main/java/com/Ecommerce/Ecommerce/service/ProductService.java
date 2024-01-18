package com.Ecommerce.Ecommerce.service;

import com.Ecommerce.Ecommerce.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ecommerce.Ecommerce.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }
    public List<Product> getProducts(){
        return repository.findAll();
    }
    public Product getProductByID(int id){
        return repository.findById(id).orElse(null);
    }
    public Product getProductByName(String productName){
        return repository.findByName(productName);
    }
    public String deleteProduct(int id){
         repository.deleteById(id);
         return "Product Removed" + id;
    }
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        assert existingProduct != null;
        existingProduct.setName(product.getName());
        existingProduct.setProduct_quantity(product.getProduct_quantity());
        existingProduct.setProduct_price(product.getProduct_price());
        existingProduct.setCategory(product.getCategory());
        return repository.save(existingProduct);

    }

}
