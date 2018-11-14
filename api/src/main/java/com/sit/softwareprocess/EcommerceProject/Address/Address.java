package com.sit.softwareprocess.EcommerceProject.Address;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    public Address() {
    }

    public int getId() { return id; }

    public String getAddressDescription() { return addressDescription; }

    public void setAddressDescription(String addressDescription) { this.soi = addressDescription; }

    public String getDistrict() { return district; }

    public void setDistrict(String district) { this.district = district; }

    public String getSubDistrict() { return subDistrict; }

    public void setSubDistrict(String subDistrict) { this.subDistrict = subDistrict; }

    public String getProvince() { return province; }

    public void setProvince(String province) { this.province = province; }

    public String getPostcode() { return postcode; }

    public void setPostcode(String postcode) { this.postcode = postcode; }
}
