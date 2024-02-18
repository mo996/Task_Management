package com.daaeboul.taskmanagementsystem.repository;

import com.daaeboul.taskmanagementsystem.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
