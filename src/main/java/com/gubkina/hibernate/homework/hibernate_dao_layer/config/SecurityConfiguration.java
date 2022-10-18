package com.gubkina.hibernate.homework.hibernate_dao_layer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

// для работы с логинами и паролями из БД
//    @Autowired
//    DataSource dataSource;
//
//    @Bean
//    public BCryptPasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("anna").password("{noop}anna").roles("ADMIN", "GUEST")
                .and()
                .withUser("tomas").password("{noop}tomas").roles("GUEST");


// для работы с логинами и паролями из БД
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select username, password, 'true' from users where username=?")
//                .authoritiesByUsernameQuery(
//                        "select u.username, r.name from users u join roles r on r.id = u.role_id "
//                        + " where username=?")
//                .rolePrefix("ROLE_");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city", "/persons/by-age", "/persons/by-name", "/persons/by-contact").hasRole("GUEST")
                .and()
                .authorizeRequests().antMatchers("/persons/**").hasRole("ADMIN")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
