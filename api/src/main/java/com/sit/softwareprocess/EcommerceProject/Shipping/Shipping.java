package com.sit.softwareprocess.EcommerceProject.Shipping;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotBlank
    @Column(name = "shiptype")
    String shipType;

    public Shipping() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }
}
