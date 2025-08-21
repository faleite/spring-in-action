package com.faleite.v_cmatheus.service;

import com.faleite.v_cmatheus.exceptions.ResourceNotFoundException;
import com.faleite.v_cmatheus.model.Product;
import com.faleite.v_cmatheus.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product ID " +id+ " not found"));
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProductById(Long id){
        if (!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Product ID " +id+ " not found");
        }
        productRepository.deleteById(id);
    }
}
