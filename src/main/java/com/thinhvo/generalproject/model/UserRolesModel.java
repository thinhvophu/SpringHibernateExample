package com.thinhvo.generalproject.model;

/**
 * Created by vinh on 3/8/2016.
 */
public class UserRolesModel extends BaseModelObject {
    private Integer id;
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
