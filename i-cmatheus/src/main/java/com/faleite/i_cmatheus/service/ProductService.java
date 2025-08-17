package com.faleite.i_cmatheus.service;

import com.faleite.i_cmatheus.exceptions.ResourceNotFoundException;
import com.faleite.i_cmatheus.model.Product;
import com.faleite.i_cmatheus.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product ID " + id + " not foud"));
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        if (!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Product ID " + id + " not foud");
        }
        productRepository.deleteById(id);
    }
}
