package com.sit.softwareprocess.EcommerceProject.Shipping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ShippingController {

    @Autowired
    ShippingService shippingService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/shipping"
    )

    public ResponseEntity <List<Shipping>> getAllShippingType (){
        List <Shipping> shippings = shippingService.getAllShippingType();
        return new ResponseEntity<List<Shipping>>(shippings, HttpStatus.OK);
    }

}
