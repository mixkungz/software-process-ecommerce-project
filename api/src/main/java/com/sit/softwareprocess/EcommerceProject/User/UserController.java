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


    public ResponseEntity<User> createUser(@RequestParam("username") String username,
                                        @RequestParam("password") String password,
                                        @RequestParam("firstname") String firstname,
                                        @RequestParam("lastname") String lastname,
                                        @RequestParam("email") String email,
                                        @RequestParam("telephonenumber") String telephoneNumber){

            boolean isAdmin = true; //if user is true and admin is false
            User user = new User(username,password,firstname,lastname,email,telephoneNumber,isAdmin);
            User userCreate = userService.createUser(user);
            return new ResponseEntity<User>(userCreate,HttpStatus.OK);
    }

}
