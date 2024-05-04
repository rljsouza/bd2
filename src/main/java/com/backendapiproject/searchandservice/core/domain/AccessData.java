package com.backendapiproject.searchandservice.core.domain;

import com.backendapiproject.searchandservice.core.domain.enums.RoleType;

import java.util.HashSet;
import java.util.Set;

public class AccessData {

    private Long id;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();


    public AccessData() {
    }

    public AccessData(Long id, String password, String username, Set<Role> roles) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setRolesProfessional(){
        this.roles.add(new Role(RoleType.ROLE_PROFESSIONAL));
    }
    public void setRolesCostumer(){
        this.roles.add(new Role(RoleType.ROLE_USER));
    }

}
