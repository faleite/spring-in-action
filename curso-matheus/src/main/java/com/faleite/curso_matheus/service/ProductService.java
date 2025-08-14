package com.faleite.curso_matheus.service;

import com.faleite.curso_matheus.model.Product;
import com.faleite.curso_matheus.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> listProducts(){
        return productRepository.findAll();
    }


}
