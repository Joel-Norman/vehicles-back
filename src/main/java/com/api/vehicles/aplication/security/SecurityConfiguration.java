package com.api.vehicles.aplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
	 @Autowired
	 UsersServicesImp userService;

	 @Autowired
	 JwtEntryPoint jwtEntryPoint;

//	    @Autowired
//	    PasswordEncoder passwordEncoder;

//	    @Bean
//	    public JwtTokenFilter jwtTokenFilter(){
//	        return new JwtTokenFilter();
//	    }
	//
//	    @Bean
//	    public PasswordEncoder passwordEncoder(){
//	        return new BCryptPasswordEncoder();
//	    }

	    /*@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}*/
	 @Autowired
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	 }
	 	@Bean
		public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,PasswordEncoder passwordEncoder) {
	        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
			authenticationProvider.setUserDetailsService(userDetailsService);
			authenticationProvider.setPasswordEncoder(passwordEncoder);
	        ProviderManager providerManager = new ProviderManager(authenticationProvider);
			providerManager.setEraseCredentialsAfterAuthentication(false);

			return providerManager;

		}

	    @Bean
	    public JwtTokenFilter jwtTokenFilter() {
	        return new JwtTokenFilter();
	    }
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	    	http
	    		.cors(t -> t.disable())
	         	.csrf(c->c.disable())
	         	.authorizeHttpRequests((authorize) -> authorize
	            .requestMatchers("/login","/register","/inform/**","/consult/**","/payment/**","/config/**","/ads/**").permitAll()
				.anyRequest().authenticated()
	         	)
	         	.exceptionHandling(t -> t.authenticationEntryPoint(jwtEntryPoint));
	        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
}
