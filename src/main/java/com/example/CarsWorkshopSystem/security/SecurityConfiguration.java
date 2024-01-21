package com.example.CarsWorkshopSystem.security;

import com.example.CarsWorkshopSystem.service.ClientService;
import com.example.CarsWorkshopSystem.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {



    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorize -> authorize
//                        .mvcMatchers("/", "/index", "/registerClient", "/registerClient/save").permitAll()
//                        .mvcMatchers("/loginClient").anonymous()
//                        .mvcMatchers("/registerWorker", "/registerWorker/save").hasRole("ADMIN")
//                        .mvcMatchers("/loginWorker").hasRole("EMPLOYEE")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(login -> login
//                        .loginPage("/loginClient")
//                        .loginProcessingUrl("/loginClient")
//                        .defaultSuccessUrl("/clientDashboard", true)
//                        .failureUrl("/loginClient?error=true")
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/")
//                        .invalidateHttpSession(true)
//                )
//                .exceptionHandling(exceptionHandling -> exceptionHandling
//                        .accessDeniedPage("/access-denied")
//                );
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(clientService).passwordEncoder(passwordEncoder)
//                .and()
//                .userDetailsService(workerService).passwordEncoder(passwordEncoder);
//    }

}
