package com.trl.springsecurityjwt.service;

import com.trl.springsecurityjwt.controller.dto.AuthenticationRequest;
import com.trl.springsecurityjwt.controller.dto.AuthenticationResponse;
import com.trl.springsecurityjwt.controller.dto.UserDTO;

public interface UserService {

    UserDTO getUser(Long id);

    AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;
}
