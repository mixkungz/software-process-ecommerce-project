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

    @CrossOrigin("*")
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


    @CrossOrigin("*")
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/auth/check"
    )
    public boolean checkToken(@RequestHeader(name = "Authorization", required = true) String token){
        return jwtService.isTokenExpire(token);
    }

    @CrossOrigin("*")
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/auth/login/facebook"
    )
    public ResponseEntity<JwtModel> loginWithFacebook(@RequestParam("facebookId") String facebookId,@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName){
        User user = userService.getUserByFacebookId(facebookId);
        if(!hasUser(user)){
            System.out.println("no user");
            user = new User();
            user.setAdmin(false);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setFacebookId(facebookId);
            user.setEmail("mockup@email.com");
            user.setUsername("%^&A*S(&CP<}D{PCOIABSVD"+facebookId+"AXB&*EQYAD%^R@&TE*Y*(U(PICNAISBD()CBCAUS(DI_)");
            user.setPassword("ABSC*&)N_(MDIN)DCABS(N+D_M+)D(_)(U*Y&T^FTVUAYBUCNIPS{K}LD"+facebookId+"AVRSAM)_ASCD(&*AST*()CD_})*(&*^^$%#$EUARCSVITBDUIP");
            user.setTelephoneNumber("191");
            user = userService.createUser(user);
        }
        JwtModel jwtModel = jwtService.generateJwtToken(user.getId());
        System.out.println();
        return new ResponseEntity<JwtModel>(jwtModel,HttpStatus.CREATED);
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
