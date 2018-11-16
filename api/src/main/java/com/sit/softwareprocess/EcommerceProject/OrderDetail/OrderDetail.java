package com.sit.softwareprocess.EcommerceProject.OrderDetail;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "orderDetail")
public class OrderDetail implements Serializable {
    @EmbeddedId
    CompositePrimaryKey id;

    @NotNull
    int amount;

    public OrderDetail() {
    }

    public CompositePrimaryKey getId() {
        return id;
    }

    public void setId(CompositePrimaryKey id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

@Embeddable
class CompositePrimaryKey implements Serializable{
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "product_id")
    private int productId;

    public CompositePrimaryKey() {
    }

    public CompositePrimaryKey(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
