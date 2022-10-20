package com.ideas2it.bookmymovie.config;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
/*    @Autowired
    AuthenticationManager authenticationManager;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/api/V1/admin").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/api/V1/booking").hasAnyAuthority("Admin","Customer");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new UserAuthenticationFilter(authenticationManager));
        http.addFilterBefore(new UserAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }*/


}
