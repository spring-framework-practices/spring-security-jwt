package com.trl.springsecurityjwt.tmp;

import com.trl.springsecurityjwt.repository.UserRepository;
import com.trl.springsecurityjwt.repository.entity.UserEntity;
import com.trl.springsecurityjwt.service.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setFirstName("Tsyupryk");
        userEntity.setLastName("Roman");
        userEntity.setUserName("TRL");
        userEntity.setEmail("tsyupryk.roman@gmail.com");
        userEntity.setPassword("pass");
        userEntity.setAccountNonExpired(true);
        userEntity.setAccountNonLocked(true);
        userEntity.setCredentialsNonExpired(true);
        userEntity.setEnabled(true);
        userEntity.setAuthorities(Set.of(UserRole.ADMIN));

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setId(2L);
        userEntity2.setFirstName("TestUserFirstName");
        userEntity2.setLastName("TestUserLastName");
        userEntity2.setUserName("test");
        userEntity2.setEmail("test@email.com");
        userEntity2.setPassword("pass");
        userEntity2.setAccountNonExpired(true);
        userEntity2.setAccountNonLocked(true);
        userEntity2.setCredentialsNonExpired(true);
        userEntity2.setEnabled(true);
        userEntity2.setAuthorities(Set.of(UserRole.USER));

        repository.save(userEntity);
        repository.save(userEntity2);
    }
}
