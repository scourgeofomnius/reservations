package com.airline.reservations;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
//@ConditionalOnProperty(value = "app.security.basic.enabled", havingValue = "false")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//                http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/**").permitAll();
//                //.anyRequest().authenticated();
//        http
//                //.addFilterBefore(muiltpartFilter, ChannelProcessingFilter.class)
//                //.addFilterBefore(cf, ChannelProcessingFilter.class)
//                .anonymous().and()
//                .authorizeRequests().anyRequest().authenticated().and()
//                .authorizeRequests()
//                .antMatchers("/**")
//                .permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login");
        http
                // disabling csrf here, you should enable it before using in production
                .csrf().disable()
                .authorizeRequests()
                // this matcher is working for all GET/POST/... , any URL matching the reg expression
                .antMatchers("/**").permitAll();
    }
}