package com.faleite.base_vii.controller;

import com.faleite.base_vii.model.Product;
import com.faleite.base_vii.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*@GetMapping
    public ResponseEntity<List<Product>> listProducts(){
        List<Product> products = new ArrayList<>();
        products = productService.listProducts();
        return ResponseEntity.ok(products);
    }*/

    @GetMapping
    public List<Product> listProducts(){
        return productService.listProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

}
