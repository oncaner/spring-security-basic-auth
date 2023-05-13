package com.caneron.springsecuritydemo.util;

import com.caneron.springsecuritydemo.model.Role;
import com.caneron.springsecuritydemo.model.User;
import com.caneron.springsecuritydemo.repository.RoleRepository;
import com.caneron.springsecuritydemo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataLoad implements ApplicationRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role roleAdmin = Role.builder().id(1L).name("ROLE_ADMIN").build();
        Role roleUser = Role.builder().id(2L).name("ROLE_USER").build();

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        List<Role> adminRoleList = new ArrayList<>();
        adminRoleList.add(roleAdmin);

        List<Role> userRoleList = new ArrayList<>();
        userRoleList.add(roleUser);

        User admin = User.builder().id(1L).name("admin").password("123").roles(adminRoleList).build();
        userRepository.save(admin);

        User user = User.builder().id(2L).name("user").password("123").roles(userRoleList).build();
        userRepository.save(user);

        System.out.println("-- Roles --");
        roleRepository.findAll().forEach(System.out::println);
        System.out.println("-- Users --");
        userRepository.findAll().forEach(System.out::println);
    }
}
