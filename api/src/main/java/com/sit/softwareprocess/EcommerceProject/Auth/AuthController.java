package com.sit.softwareprocess.EcommerceProject.Auth;

import com.sit.softwareprocess.EcommerceProject.User.User;
import com.sit.softwareprocess.EcommerceProject.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    JwtService jwtService;
    @Autowired
    UserService userService;

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/auth/login"
    )
    public ResponseEntity<JwtModel> loginWithUsername(@RequestParam("username") String username, @RequestParam("password")String password){
        User user = userService.getUserByUsername(username);
        if(!hasUser(user) || isWrongPassword(user,password)) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        JwtModel jwtModel = jwtService.generateJwtToken(user.getId());
        return new ResponseEntity<JwtModel>(jwtModel,HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/auth/check"
    )
    public boolean checkToken(@RequestHeader(name = "Authorization", required = true) String token){
        return jwtService.isTokenExpire(token);
    }

    public boolean hasUser(User user){
        if(user == null) return false;
        return true;
    }
    public boolean isWrongPassword(User user,String password){
        if(user.getPassword().equals(password)) return false;
        return true;
    }
}
