package com.sit.softwareprocess.EcommerceProject.Address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sit.softwareprocess.EcommerceProject.Order.Order;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotBlank
    @Column(name = "address_description")
    String addressDescription;

    @NotBlank
    String district;

    @NotBlank
    @Column(name = "sub_district")
    String subDistrict;

    @NotBlank
    String province;

    @NotBlank
    String postcode;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "address")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Order order;

    public Address() {
    }

    public Address(@NotBlank String addressDescription, @NotBlank String district, @NotBlank String subDistrict, @NotBlank String province, @NotBlank String postcode) {
        this.addressDescription = addressDescription;
        this.district = district;
        this.subDistrict = subDistrict;
        this.province = province;
        this.postcode = postcode;
    }

    public int getId() { return id; }

    public String getAddressDescription() { return addressDescription; }

    public void setAddressDescription(String addressDescription) { this.addressDescription = addressDescription; }

    public String getDistrict() { return district; }

    public void setDistrict(String district) { this.district = district; }

    public String getSubDistrict() { return subDistrict; }

    public void setSubDistrict(String subDistrict) { this.subDistrict = subDistrict; }

    public String getProvince() { return province; }

    public void setProvince(String province) { this.province = province; }

    public String getPostcode() { return postcode; }

    public void setPostcode(String postcode) { this.postcode = postcode; }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }
}
