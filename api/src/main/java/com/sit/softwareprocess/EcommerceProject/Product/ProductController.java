package com.sit.softwareprocess.EcommerceProject.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/products"
    )
    public ResponseEntity <List<Product>> getAllProducts(){
            List<Product> products = productService.getAllProducts();
            return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/products/{sku}"
    )
    public ResponseEntity <Product> getProductBySku(@PathVariable("sku") int sku){
            Product product = productService.getProductBySku(sku);
            return new ResponseEntity<Product>(product,HttpStatus.OK);
    }


}
