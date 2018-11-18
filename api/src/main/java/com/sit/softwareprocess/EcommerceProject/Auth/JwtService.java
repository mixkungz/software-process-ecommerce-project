package com.sit.softwareprocess.EcommerceProject.Auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    String secretKey;

    private JwtModel jwtModel;

    public JwtModel generateJwtToken(int userId){
        try{
            int millisecToSec = 1000;
            int hour = 60*60*millisecToSec;
            Date expDate = new Date(System.currentTimeMillis()+hour);

            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            String token = JWT.create()
                    .withClaim("id",userId)
                    .withClaim("exp",expDate.getTime())
                    .withExpiresAt(expDate)
                    .sign(algorithm);

            jwtModel = new JwtModel();
            jwtModel.setToken(token);
            jwtModel.setExp(expDate.getTime());

            return jwtModel;
        }catch(JWTCreationException exception){
            return null;
        }
    }

}
