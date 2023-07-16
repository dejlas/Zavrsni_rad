package com.ds.doniraj.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="blood_type", schema = "doniraj")
public class BloodType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  symbol;
    @OneToMany(
            mappedBy = "bloodType",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true
    )
    private List<User> users =new ArrayList<>();

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return getSymbol();
    }
}
