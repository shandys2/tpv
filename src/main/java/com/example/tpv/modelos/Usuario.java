package com.example.tpv.modelos;

import javax.persistence.*;
import javax.persistence.Entity;


@Entity(name ="USUARIOS")
@Table(name = "USUARIOS")

public class Usuario {

    private int userId;

    private String username;

    private String password;

    private Boolean admin;

    public Usuario(){}

    @Id
    @GeneratedValue
    @Column(name = "USERID", unique = true , nullable = false )
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "USERNAME", unique = true , nullable = false)
    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }
    @Column(name = "PASSWORD", nullable = false)
    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = pass;
    }
    @Column(name = "ADMIN", nullable = false)
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }


}
