package com.security.app.services.impl;

import com.security.app.services.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key; //check
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTServiceImpl implements JWTService {
    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60+24))  //morethan 1 day
                .signWith(getSigninKey(), SignatureAlgorithm.HS256) //algorithm
                .compact();
    }
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers){ // to get particular claim
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }
    private Key getSigninKey(){
        byte[] key = Decoders.BASE64.decode("");
        return Keys.hmacShaKeyFor(key);
    }

    public String ExtractUSerName(String token){
        return extractClaim(token, Claims::getSubject);
    }

    private Claims extractAllClaims(String token){ //extract token
        return Jwts.parserBuilder().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody();
    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username=extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token){
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    @Override
    public String extractUserName(String token) { //check the implementation code in youtube
        return null;
    }
}
