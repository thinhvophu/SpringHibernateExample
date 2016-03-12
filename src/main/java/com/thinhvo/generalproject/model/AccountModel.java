package com.thinhvo.generalproject.model;

import java.util.Set;

/**
 * Created by vinh on 3/8/2016.
 */
public class AccountModel extends BaseModelObject {

    private Integer id;
    private String userName;
    private String password;
    private Set<UserRolesModel> roles;

    public Set<UserRolesModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRolesModel> roles) {
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{Account [id:" + id + ", userName:" + userName + ", password:"
                + password + "]}";
    }
}
