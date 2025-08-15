package com.faleite.curso_matheus.service;

import com.faleite.curso_matheus.exceptions.ResourceNotFoundException;
import com.faleite.curso_matheus.model.Product;
import com.faleite.curso_matheus.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    /* NO USE OF EXCEPTION
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }*/
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product ID " + id + " not found"));
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    /* NO USE OF EXCEPTION
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }*/
    public void deleteProduct(Long id){
        if (!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Product ID " + id + " not exist");
        }
        productRepository.deleteById(id);
    }
}
