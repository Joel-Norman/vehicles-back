package com.api.vehicles.infraestructura.adapter.inputs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.api.vehicles.aplication.ports.inputs.LoginPort;
import com.api.vehicles.aplication.security.JwtProvider;
import com.api.vehicles.domain.Login;
import com.api.vehicles.domain.Session;
import com.api.vehicles.infraestructura.adapter.outputs.entities.User;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.UserRespository;
@Service
public class LoginAdapter implements LoginPort{
	@Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
	@Autowired
	UserRespository userRepo;
	@Override
	public Session loginUser(Login login) {
		try {
            User acc=userRepo.findByUsername(login.getEmail());

            if(acc==null){
                return null;
            }
            Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtProvider.generateToken(login.getEmail());

            UserDetails userDetails = (UserDetails)authentication.getPrincipal();
            
            Session session = new Session();
            session.setEmail(userDetails.getUsername());
            session.setToken(jwt);
            
            
            return session;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

}
