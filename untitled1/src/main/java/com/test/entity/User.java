package com.test.entity;

import javax.persistence.*;
import java.io.*;

/**
 * Created by user on 11.09.2015.
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "LOGIN", unique = true)
	private String login;

	@Column(name = "EMAIL")
	private String eMail;

	@Column(name = "DISABLE")
	private Boolean disable;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
