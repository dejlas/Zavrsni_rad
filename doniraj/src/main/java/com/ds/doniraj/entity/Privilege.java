package com.ds.doniraj.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
    @Entity
    @Table(name="privileges", schema = "doniraj")
    public class Privilege implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String role;
        @OneToMany(
                mappedBy = "privilege",
                cascade = CascadeType.PERSIST,
                orphanRemoval = true
        )
        private List<User> users =new ArrayList<>();

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return getRole();
        }

    }

