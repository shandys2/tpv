package com.example.tpv;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue
    @Column(name = "USERID", unique = true , nullable = false )
    public int userId;
    @Column(name = "USERNAME")
    public String username;
    @Column(name = "PASSWORD")
    public String password;
    @Column(name = "ADMIN")
    public Boolean admin;

    public Usuario(){}
    @Column(name = "userid")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "username")
    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }
    @Column(name = "password")
    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = pass;
    }
    @Column(name = "admin")
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }


}
