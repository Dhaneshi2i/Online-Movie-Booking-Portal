package com.ideas2it.bookmymovie.config;

import com.ideas2it.bookmymovie.filter.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/authenticate").permitAll()
                .antMatchers(HttpMethod.POST,"/api/v1/user").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v1/user/{id}").hasAuthority("Customer")
                .antMatchers(HttpMethod.GET,"/api/v1/user").hasAuthority("Admin")
                .antMatchers(HttpMethod.PATCH,"/api/v1/user").hasAnyAuthority("Customer","Admin")
                .antMatchers("/api/v1/role").hasAuthority("Admin")
                .antMatchers("/api/v1/cast").hasAuthority("Admin")
                .antMatchers("/api/v1/language").hasAuthority("Admin")
                .antMatchers("/api/v1/genre").hasAuthority("Admin")
                .antMatchers("/api/v1/screen").hasAuthority("Admin")
                .antMatchers("/api/v1/seat-type").hasAuthority("Admin")
                .antMatchers("/api/v1/time-slot").hasAuthority("Admin")
                .antMatchers("/api/v1/screen/").hasAuthority("Admin")
                .antMatchers(HttpMethod.POST,"/api/v1/movie").hasAuthority("Admin")
                .antMatchers(HttpMethod.GET,"/api/v1/movie").hasAnyAuthority("Admin","Customer")
                .antMatchers("/api/v1/show").hasAuthority("Admin")
                .antMatchers(HttpMethod.GET,"/api/v1/show").hasAnyAuthority("Admin","Customer")
                .anyRequest().authenticated().and()
                .exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}



