package com.sit.softwareprocess.EcommerceProject.Order;

import com.google.gson.*;
import com.sit.softwareprocess.EcommerceProject.Address.Address;
import com.sit.softwareprocess.EcommerceProject.Address.AddressService;
import com.sit.softwareprocess.EcommerceProject.Auth.JwtService;
import com.sit.softwareprocess.EcommerceProject.OrderDetail.OrderDetail;
import com.sit.softwareprocess.EcommerceProject.OrderDetail.OrderDetailService;
import com.sit.softwareprocess.EcommerceProject.Payment.Payment;
import com.sit.softwareprocess.EcommerceProject.Product.Product;
import com.sit.softwareprocess.EcommerceProject.Product.ProductService;
import com.sit.softwareprocess.EcommerceProject.Shipping.Shipping;
import com.sit.softwareprocess.EcommerceProject.User.User;
import com.sit.softwareprocess.EcommerceProject.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;


@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    AddressService addressService;

    @Autowired
    UserService userService;

    @Autowired
    JwtService jwtService;

    @CrossOrigin("*")
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/order"
    )
        public ResponseEntity<Order> createOrder(
            @RequestHeader(name = "Authorization", required = true) String token,
            @RequestBody String jsonData
    ){

        if(jwtService.isTokenExpire(token)){ return new ResponseEntity(HttpStatus.BAD_REQUEST); }

        int userId = jwtService.getUserIdFromToken(token);
        User user = userService.getUserById(userId);

        Gson gson = new Gson();

        JsonElement jsonElement = new JsonParser().parse(jsonData);
        JsonObject  jsonObject = jsonElement.getAsJsonObject();

        JsonObject orderJson = jsonObject.getAsJsonObject("order");
        JsonObject addressJson = jsonObject.getAsJsonObject("address");
        JsonObject shippingJson = jsonObject.getAsJsonObject("shipping");
        JsonObject paymentJson = jsonObject.getAsJsonObject("payment");
        JsonArray productJson = jsonObject.getAsJsonArray("product");
        JsonArray amountJson = jsonObject.getAsJsonArray("amount");

        Order order = gson.fromJson(orderJson,Order.class);
        Address address = gson.fromJson(addressJson,Address.class);
        Shipping shipping = gson.fromJson(shippingJson,Shipping.class);
        Payment payment = gson.fromJson(paymentJson,Payment.class);
        String[] productList = gson.fromJson(productJson,String[].class);
        int[] amount = gson.fromJson(amountJson,int[].class);

        int totalAmount = 0;
        if(amount.length == productList.length) {
            for (int qty : amount) {
                totalAmount += qty;
            }
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Address addressCreate = addressService.createAddress(address);
        order.setAddress(addressCreate);
        order.setShipping(shipping);
        order.setPayment(payment);
        order.setUser(user);
        order.setAmount(totalAmount);
        order.setCreateAt(new Date());

        Order orderCreate = orderService.createOrder(order);

        for (int i = 0; i< productList.length; i++){
            Product product = productService.getProductBySku(productList[i]);
            OrderDetail orderDetail = orderDetailService.createOrderDetail(orderCreate.getId(),product.getId(),amount[i]);
        }

        return new ResponseEntity<Order>(orderCreate, HttpStatus.OK);
    }

}
