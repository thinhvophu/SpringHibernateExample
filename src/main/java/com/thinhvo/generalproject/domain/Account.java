package com.thinhvo.generalproject.domain;

import javax.persistence.CascadeType;
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
import java.util.Set;

@Entity
@Table(name = "Account")
public class Account extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -710824558428757476L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "username", unique = true)
	private String userName;

	@Column(name = "password")
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="account_roles",
				joinColumns = {@JoinColumn(name="account")},
				inverseJoinColumns = {@JoinColumn(name="roles")})
	private Set<UserRoles> roles ;

	public Set<UserRoles> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRoles> roles) {
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
