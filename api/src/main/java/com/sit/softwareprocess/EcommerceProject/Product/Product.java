package com.sit.softwareprocess.EcommerceProject.Product;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "productid")
    int id;

    @NotBlank
    @Column(name = "product_name")
    String productName;

    @NotBlank
    @Column(name = "product_price")
    double productPrice;

    @NotBlank
    @Column(name = "sku")
    String sku;

    @NotBlank
    @Column(name = "product_image")
    String productImage;

    @NotBlank
    @Column(name = "product_description")
    String productDescription;

    @NotBlank
    @Column(name = "number_of_stock")
    int numberOfStock;

    @NotBlank
    @Column(name = "weight")
    double weight;

    @NotBlank
    @Column(name = "width")
    double width;

    @NotBlank
    @Column(name = "height")
    double height;

    @NotBlank
    @Column(name = "length")
    double length;

    @NotBlank
    @Column(name = "size")
    String size;

    @NotBlank
    @Column(name = "color")
    String color;

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getNumberOfStock() {
        return numberOfStock;
    }

    public void setNumberOfStock(int numberOfStock) {
        this.numberOfStock = numberOfStock;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
