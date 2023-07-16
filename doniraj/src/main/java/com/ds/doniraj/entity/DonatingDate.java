package com.ds.doniraj.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "donating_date", schema = "doniraj")
public class DonatingDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Override
    public String toString() {
        return user.getUsername();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {this.date = date;}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

