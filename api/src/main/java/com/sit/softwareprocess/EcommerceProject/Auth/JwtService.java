package com.sit.softwareprocess.EcommerceProject.Auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    private JwtModel jwtModel;

    public JwtModel generateJwtToken(int userId){
        try{

            Calendar cal = Calendar.getInstance(); // creates calendar
            cal.setTime(new Date());
            cal.add(Calendar.HOUR_OF_DAY, 1);

            Date expDate = cal.getTime();
            long expTime = cal.getTimeInMillis();

            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            String token = JWT.create()
                    .withClaim("id",userId)
                    .withClaim("exp",expTime)
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
