package com.ds.doniraj.entity;
import jakarta.persistence.*;
import java.io.Serializable;



@Entity
@Table (name="users", schema = "doniraj")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username", unique = true)
    @Basic(optional = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "privilege_id", nullable = true)
    private Privilege privilege;

    @ManyToOne
    @JoinColumn(name = "blood_type_id")
    private BloodType bloodType;
    @ManyToOne
    @JoinColumn(name = "town_id", nullable = true)
    private Town town;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Privilege getPrivilege() {return privilege;}
    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType){this.bloodType = bloodType;}

}
