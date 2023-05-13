package com.caneron.springsecuritydemo.repository;

import com.caneron.springsecuritydemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
