package com.api.vehicles.aplication.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UsersServicesImp userDetailsService;

    

    private String getToken(HttpServletRequest request){
    	//request.getHeaderNames().asIterator().forEachRemaining(header -> 
	    //    System.out.println(header + ": " + request.getHeader(header))
	    //);
    	//request.getHeaderNames().asIterator().forEachRemaining(t->System.out.println(t));
        String token = null;
        String header = request.getParameter("key");
        if(header!=null){
        	System.out.println("token encontrado");
            //token = header.replace("Bearer ", "");
        	token=header;
            System.out.println("token: "+token);
        }

        if(token != null)
            return token;
        System.out.println("sin token");
        return null;
    }

    @Override

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getToken(request);
            if(token != null && jwtProvider.validateToken(token)){
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("fail en el método doFilter " + e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}