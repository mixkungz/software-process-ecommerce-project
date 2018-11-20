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
            value = "/users"
    )
    public ResponseEntity<User> createUser(@RequestBody User user){
            user.setAdmin(false);
            User user_object = userService.createUser(user);
            return new ResponseEntity<User>(user_object,HttpStatus.OK);

    }

}
