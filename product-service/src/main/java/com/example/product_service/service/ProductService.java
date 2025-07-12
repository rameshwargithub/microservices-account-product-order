package com.example.product_service.service;

import com.example.product_service.data.Product;
import com.example.product_service.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public Product createProduct(Product product) {
        product.setProductId("P"+ UUID.randomUUID().toString().substring(0,5));
        return productRepo.save(product);
    }

    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    public Product getProductById(String productId) {
        return productRepo.findByProductId(productId).orElseThrow();
    }

    public Product updateProductById(String productId,Product product) {
        Product product1=getProductById(productId);
        String productName=product.getName();
        double price=product.getPrice();

        if(product1!=null){
            if(productName!=null&&!productName.isBlank()){
                product1.setName(productName);
            }
            if(price>0){
                product1.setPrice(price);
            }
            productRepo.save(product1);
        }
        return product1;
    }
    public long deleteProduct(String productId){
        return productRepo.deleteByProductId(productId);
    }
}
