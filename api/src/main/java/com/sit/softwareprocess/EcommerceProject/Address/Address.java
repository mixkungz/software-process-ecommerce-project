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

    @NotNull
    @Column(name = "home_number")
    String homeNumber;

    String soi;

    @NotBlank
    String road;

    String village;

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

    public String getHomeNumber() { return homeNumber; }

    public void setHomeNumber(String homeNumber) { this.homeNumber = homeNumber; }

    public String getSoi() { return soi; }

    public void setSoi(String soi) { this.soi = soi; }

    public String getRoad() { return road; }

    public void setRoad(String road) {this.road = road; }

    public String getVillage() { return village; }

    public void setVillage(String village) { this.village = village; }

    public String getDistrict() { return district; }

    public void setDistrict(String district) { this.district = district; }

    public String getSubDistrict() { return subDistrict; }

    public void setSubDistrict(String subDistrict) { this.subDistrict = subDistrict; }

    public String getProvince() { return province; }

    public void setProvince(String province) { this.province = province; }

    public String getPostcode() { return postcode; }

    public void setPostcode(String postcode) { this.postcode = postcode; }
}
