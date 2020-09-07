package com.trl.springsecurityjwt.service;

import com.trl.springsecurityjwt.repository.UserRepository;
import com.trl.springsecurityjwt.repository.entity.UserEntity;
import com.trl.springsecurityjwt.service.converter.UserConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsImpl resultUserDetails = null;

        Optional<UserEntity> byUserName = repository.findByUserName(username);

        resultUserDetails = UserConverter.mapEntityToUserDetails(byUserName.orElseThrow(() -> new UsernameNotFoundException("User by name " + username + " not exist !!!")));

        return resultUserDetails;
    }
}
