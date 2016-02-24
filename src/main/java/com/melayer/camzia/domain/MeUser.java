/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melayer.camzia.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author aniruddha
 */
@Entity
@Table(name = "me_user")
public class MeUser {

    private Long idUser;

    private String userName;

    private String password;

    private Set<MeRole> roles = new HashSet<>();

    public MeUser() {
    }
    
    public MeUser(MeUser user) {
        
        this.idUser = user.getIdUser();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }
    
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", unique = true, nullable = false)
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    @Column(name = "name_user", unique = false, nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password_user", unique = false, nullable = false)
    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {
        @JoinColumn(name = "id_user")}, inverseJoinColumns = {
        @JoinColumn(name = "id_role")})
    public Set<MeRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<MeRole> roles) {
        this.roles = roles;
    }

}
