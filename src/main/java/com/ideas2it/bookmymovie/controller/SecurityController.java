package com.ideas2it.bookmymovie.controller;

import com.ideas2it.bookmymovie.model.AuthRequest;
import com.ideas2it.bookmymovie.model.AuthResponse;
import com.ideas2it.bookmymovie.service.UserService;
import com.ideas2it.bookmymovie.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * SecurityController will create authentication token
 * </p>
 *
 * @author Dhanesh kumar, Harini, sivadharshini
 * @version 1.0
 **/
@RestController
public class SecurityController {

    private AuthenticationManager authenticationManager;

    private JwtUtil tokenUtil;

    private UserService userService;

    public PasswordEncoder passwordEncoder;

    public SecurityController(AuthenticationManager authenticationManager, JwtUtil tokenUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenUtil = tokenUtil;
        this.userService = userService;
    }

    /**
     * <p>
     *  This method creates authentication token.
     * </p>
     *
     * @param authenticationRequest it contains AuthRequest objects
     * @return
     */
    @RequestMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authenticationRequest) throws Exception {
        try {
//                authenticationRequest.setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
//                 System.out.println(authenticationRequest.getPassword());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException badCredentialsException) {
            throw new Exception("Incorrect userName or password");
        }
        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUserName());
        final String webToken = tokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(webToken));
    }
}