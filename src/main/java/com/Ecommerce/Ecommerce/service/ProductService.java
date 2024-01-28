package com.Ecommerce.Ecommerce.service;

import com.Ecommerce.Ecommerce.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ecommerce.Ecommerce.repository.ProductRepository;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(String name, String category, int productQuantity, int productRatings, double productPrice, MultipartFile imageFile) throws IOException {
        Product product1 = new Product();
        product1.setName(name);
        product1.setCategory(category);
        product1.setProduct_quantity(productQuantity);
        product1.setProduct_ratings(productRatings);
        product1.setProduct_price(productPrice);
        product1.setImage(imageFile.getBytes());
        return repository.save(product1);
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
        existingProduct.setImage(product.getImage());
        return repository.save(existingProduct);

    }

}
