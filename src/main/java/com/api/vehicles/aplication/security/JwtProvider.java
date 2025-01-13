package com.api.vehicles.aplication.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import java.util.List;

@Component
public class JwtProvider {
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    //@Value("${jwt.secret}")
    private String secret="a89sd70f9a9s8df098a70987987a9sd79897gfg9d8f799re9";
    
    //@Value("${jwt.expiration}")
    private int expiration=259200;

    public String generateToken(String username){
        //UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder()
        		.subject(username)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(getKey())// (4) if signing, or
                //.encryptWith(key, keyAlg, encryptionAlg)  //     if encrypting
                //.signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private SecretKey getKey() {
       byte[] keyBytes=Decoders.BASE64.decode(secret);
       return Keys.hmacShaKeyFor(keyBytes);
    }
    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public boolean validateToken(String token){
        try {
        	Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("token expirado");
        }catch (IllegalArgumentException e){
            logger.error("token vacío");
        }catch (SignatureException e){
            logger.error("fail en la firma");
        }
        return false;
    }
    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload();

        String username = claims.getSubject();
        List<GrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        UserDetails userDetails = new User(username, "", authorities);

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }
}
