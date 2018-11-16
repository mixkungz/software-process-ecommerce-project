package com.sit.softwareprocess.EcommerceProject.Order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sit.softwareprocess.EcommerceProject.OrderDetail.OrderDetail;
import com.sit.softwareprocess.EcommerceProject.Payment.Payment;
import com.sit.softwareprocess.EcommerceProject.Shipping.Shipping;
import com.sit.softwareprocess.EcommerceProject.User.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Payment payment;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shipping_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Shipping shipping;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    @JoinColumn(name = "orderDetail_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    OrderDetail OrderDetail;

    @NotNull
    @Column(name = "total_price")
    double totalPrice;

    @NotNull
    int amount;

    @NotNull
    @Column(name = "total_shipping_price")
    double totalShippingPrice;

    @CreatedDate
    @Column(name = "create_at")
    Date createAt;

    public Order() {
    }

    public int getId() { return id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Payment getPayment() { return payment; }

    public void setPayment(Payment payment) { this.payment = payment; }

    public Shipping getShipping() { return shipping; }

    public void setShipping(Shipping shipping) { this.shipping = shipping; }

    public OrderDetail getOrderDetail() { return OrderDetail; }

    public void setOrderDetail( OrderDetail orderDetail) { OrderDetail = orderDetail; }

    public double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public int getAmount() { return amount; }

    public void setAmount(int amount) { this.amount = amount; }

    public double getTotalShippingPrice() { return totalShippingPrice; }

    public void setTotalShippingPrice(double totalShippingPrice) { this.totalShippingPrice = totalShippingPrice; }

    public Date getCreateAt() { return createAt; }

    public void setCreateAt(Date createAt) { this.createAt = createAt; }
}
