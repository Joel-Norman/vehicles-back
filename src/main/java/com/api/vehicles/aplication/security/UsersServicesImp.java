/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.vehicles.aplication.security;


import com.api.vehicles.infraestructura.adapter.outputs.entities.User;
import com.api.vehicles.infraestructura.adapter.outputs.repositories.UserRespository;




import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 *
 * @author Joel
 */
@Service
public class UsersServicesImp implements UserDetailsService{

    @Autowired
    UserRespository userRepo;

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User account=userRepo.findByUsername(username);
	    if(account == null) {
		    throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new org.springframework.security.core.userdetails.User(account.getUsername(),account.getPassword(), mapearAutoridadesRoles("USER"));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(String rol){
        return List.of(new SimpleGrantedAuthority((rol)));
//return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRol())).collect(Collectors.toList());
    }
   


}
