package com.example.product_service.controller;

import com.example.product_service.ProductServiceApplication;
import com.example.product_service.data.Product;
import com.example.product_service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-apis")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping()
    private String test(){
        return "ok";
    }
    @PostMapping("product")
    private ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
        return ResponseEntity.status(201).body(productService.createProduct(product));
    }
    @GetMapping("product")
    private ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }
    @GetMapping("product/{productId}")
    private ResponseEntity<Product> getProductByProductId(@PathVariable String productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }
    @PatchMapping("product/{productId}")
    private ResponseEntity<Product> updateProductByProductId(@PathVariable String productId,@RequestBody Product product){
        return ResponseEntity.ok(productService.updateProductById(productId,product));
    }
    @DeleteMapping("product/{productId}")
    private ResponseEntity<?> deleteProductByProductId(@PathVariable String productId){
        boolean isDeleted=productService.deleteProduct(productId)==1;
        return isDeleted?ResponseEntity.status(200).body("product deleted successfully"):ResponseEntity.status(204).body("product not found");
    }
}
