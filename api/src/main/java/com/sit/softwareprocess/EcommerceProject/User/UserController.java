package com.sit.softwareprocess.EcommerceProject.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    private User user;


    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/users/{id}"
    )
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        user = userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/createUser"
    )


    public ResponseEntity<User> createUser(@RequestParam("username") String userName,
                                        @RequestParam("password") String password,
                                        @RequestParam("firstname") String firstName,
                                        @RequestParam("lastname") String lastName,
                                        @RequestParam("email") String email,
                                        @RequestParam("telephonenumber") String telephoneNumber){

            boolean isAdmin = true; //if user is true and admin is false
            userService.createUser(userName,password,firstName,lastName,email,telephoneNumber,isAdmin);
            System.out.println("Password : "+password);
            return new ResponseEntity<User>(user,HttpStatus.OK);

    }

}
