package com.sit.softwareprocess.EcommerceProject.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return  products;
    }

    public Product getProductBySku(int sku){
        Product product = productRepository.findBySku(sku);
        return product;
    }



}
