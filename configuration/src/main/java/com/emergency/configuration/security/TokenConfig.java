package com.emergency.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
public class TokenConfig {

    private final String jWTKEY="erer4567HHPP";
    private final Long VALID_TIME_SECONDS=2_592_000L;

    public String generateToken(UserDetails userDetails, Map<String,Object> claims){
        return  Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis()+VALID_TIME_SECONDS*1000))
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512,jWTKEY)
                .compact();
    }
   public  Boolean isTokenValid(String token,UserDetails userDetails){
        return (!isTokenExpired(token))&&(userDetails.getUsername().equals(extractUserName(token)));
   }
    public  Boolean isTokenExpired(String token){
        Date dateExpire= extractClaim(token,Claims::getExpiration);
        return dateExpire.before(new Date());
    }
    public Claims extractClaims(String token){
        return Jwts.parser().setSigningKey(jWTKEY).parseClaimsJws(token).getBody();
    }
    public String extractUserName(String token){
        return extractClaim(token,Claims::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolve){
        Claims claims=extractClaims(token);
        return claimsResolve.apply(claims);
    }
}
