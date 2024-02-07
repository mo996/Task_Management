package com.daaeboul.taskmanagementsystem.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name", nullable = false, unique = true)
    private String name;

    // Enum for role types
    public enum RoleType {
        ROLE_USER, ROLE_ADMIN
    }

    // Constructor for JPA
    protected Role() {
    }

    // Public constructor for creating instances
    public Role(RoleType roleType) {
        this.name = roleType.name();
    }
}
