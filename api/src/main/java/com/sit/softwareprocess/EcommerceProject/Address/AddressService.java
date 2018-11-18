package com.sit.softwareprocess.EcommerceProject.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    private Address address;

    public void createAddress(String addressDes,String district,String subDistrict,String province,String postCode){

        address = new Address(addressDes,district,subDistrict,province,postCode);
        addressRepository.save(address);
    }

}
