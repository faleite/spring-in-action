package com.faleite.iii_cmatheus.controller;

import com.faleite.iii_cmatheus.exceptions.HandlerProductNotFoundException;
import com.faleite.iii_cmatheus.model.Product;
import com.faleite.iii_cmatheus.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findProducts(){
        return productService.findProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id){
        Product product = productService.findProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducts(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
