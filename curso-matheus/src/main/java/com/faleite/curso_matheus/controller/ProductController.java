package com.faleite.curso_matheus.controller;

//import com.faleite.curso_matheus.exceptions.ResourceNotFoundException;
import com.faleite.curso_matheus.model.Product;
import com.faleite.curso_matheus.service.ProductService;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listProducts(){
        return productService.listProducts();
    }

    /* NO USE OF EXCEPTION ON CLASS CONTROLLER
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }*/
    /* WITH ResourceNotFoundException
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);
    }

    // TRATAR EM CASO DE POST INVALIDO (POIS ESTA CRIANDO PRODUCT C/ CAMPOS NULOS)
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
