package com.trl.springsecurityjwt.service.converter;

import com.trl.springsecurityjwt.controller.dto.UserDTO;
import com.trl.springsecurityjwt.repository.entity.UserEntity;
import com.trl.springsecurityjwt.service.UserDetailsImpl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserConverter {

    public static UserDTO mapEntityToDTO(UserEntity entity) {
        UserDTO resultUser = new UserDTO();

        if (entity == null) {
            throw new IllegalArgumentException("Parameter UserEntity is null !!!");
        }

        resultUser.setId(entity.getId());
        resultUser.setFirstName(entity.getFirstName());
        resultUser.setLastName(entity.getLastName());
        resultUser.setUserName(entity.getUserName());
        resultUser.setEmail(entity.getEmail());
        resultUser.setPassword(entity.getPassword());
        resultUser.setAccountNonExpired(entity.getAccountNonExpired());
        resultUser.setAccountNonLocked(entity.getAccountNonLocked());
        resultUser.setCredentialsNonExpired(entity.getCredentialsNonExpired());
        resultUser.setEnabled(entity.getEnabled());
        resultUser.setAuthorities(entity.getAuthorities());

        return resultUser;
    }

    public static UserDetailsImpl mapEntityToUserDetails(UserEntity entity) {

        if (entity == null) {
            throw new IllegalArgumentException("Parameter UserEntity is null !!!");
        }

        UserDetailsImpl resultUser = new UserDetailsImpl();

        final String rolePrefix = "ROLE_";

        resultUser.setUserName(entity.getUserName());
        resultUser.setPassword(entity.getPassword());
        resultUser.setAccountNonExpired(entity.getAccountNonExpired());
        resultUser.setAccountNonLocked(entity.getAccountNonLocked());
        resultUser.setCredentialsNonExpired(entity.getCredentialsNonExpired());
        resultUser.setEnabled(entity.getEnabled());
        resultUser.setAuthorities(entity.getAuthorities()
                .stream()
                .map(role -> new SimpleGrantedAuthority( rolePrefix + role.name()))
                .collect(Collectors.toSet()));

        return resultUser;
    }
}
