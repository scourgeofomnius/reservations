package com.airline.reservations;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.stereotype.Component;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

@Configuration
@ConditionalOnProperty(value = "app.security.basic.enabled", havingValue = "false")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    public void configure(WebSecurity web) {
//        // Ignoring here is only for this example. Normally people would apply their own authentication/authorization policies
//        web.ignoring().antMatchers("/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .headers()
//                .xssProtection()
//                .and()
//                .contentSecurityPolicy("script-src 'self'");
//    }
}
