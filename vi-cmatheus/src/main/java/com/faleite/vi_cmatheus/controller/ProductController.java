package com.faleite.vi_cmatheus.controller;

import com.faleite.vi_cmatheus.exceptions.ResourceNotFoundException;
import com.faleite.vi_cmatheus.model.Product;
import com.faleite.vi_cmatheus.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping // Porque nao usa ResponseEntity
    public List<Product> getProducts(){
        return productService.listProducts();
    }

    @GetMapping("/{id}") // Quais outras formas de tratar isto
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping // Porque nao usa ResponseEntity
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}") // Quais outras formas de tratar isto
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
