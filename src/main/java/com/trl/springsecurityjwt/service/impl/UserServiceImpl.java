package com.trl.springsecurityjwt.service.impl;

import com.trl.springsecurityjwt.controller.dto.AuthenticationRequest;
import com.trl.springsecurityjwt.controller.dto.AuthenticationResponse;
import com.trl.springsecurityjwt.controller.dto.UserDTO;
import com.trl.springsecurityjwt.service.UserDetailsServiceImpl;
import com.trl.springsecurityjwt.service.UserService;
import com.trl.springsecurityjwt.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Override
    public UserDTO getUser(Long id) {
        return null;
    }

    @Override
    public AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {
        AuthenticationResponse response = null;

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password !!!", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        response = new AuthenticationResponse(jwt);

        return response;
    }
}