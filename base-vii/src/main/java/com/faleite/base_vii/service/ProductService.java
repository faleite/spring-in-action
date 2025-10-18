package com.faleite.base_vii.service;

import com.faleite.base_vii.exceptions.ResourceNotFoundException;
import com.faleite.base_vii.model.Product;
import com.faleite.base_vii.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product ID " +id+ " not found"));
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProductById(Long id){
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product ID " +id+ " not found");
        }
        productRepository.deleteById(id);
    }
}
