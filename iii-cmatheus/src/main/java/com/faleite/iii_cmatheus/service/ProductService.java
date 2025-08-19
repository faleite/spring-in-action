package com.faleite.iii_cmatheus.service;

import com.faleite.iii_cmatheus.exceptions.HandlerProductNotFoundException;
import com.faleite.iii_cmatheus.model.Product;
import com.faleite.iii_cmatheus.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                .orElseThrow(() -> new HandlerProductNotFoundException("Product ID " + id + " not found"));
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        if (!productRepository.existsById(id)){
            throw new HandlerProductNotFoundException("Product ID " + id + " not found");
        }
        productRepository.deleteById(id);
    }

}
