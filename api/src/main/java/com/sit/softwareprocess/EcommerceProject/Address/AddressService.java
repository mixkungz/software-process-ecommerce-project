package com.sit.softwareprocess.EcommerceProject.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    

    public Address createAddress(Address address{
        return addressRepository.save(address);
    }

}
