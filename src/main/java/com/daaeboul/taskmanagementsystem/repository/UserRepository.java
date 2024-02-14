package com.daaeboul.taskmanagementsystem.repository;

import com.daaeboul.taskmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface UserRepository extends JpaRepository<User, Long> {

}
