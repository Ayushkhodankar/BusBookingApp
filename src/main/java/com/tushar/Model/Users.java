package com.tushar.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@NotNull(message = "Email can't be null")
	private String email;
	private String mobile;
	private String role;
	@NotNull(message = "Username can't be null")
	private String username;
	@NotNull(message = "Password ID can't be null")
	private String password;
	private char isActive;
	private Date createAt;
	private Date updateAt;
	
	@Transient
	private String status;
	
	public Users() {
		super();
	}

	

	public Users(int id, String name, @NotNull(message = "Email can't be null") String email, String mobile,
			String role, @NotNull(message = "Username can't be null") String username,
			@NotNull(message = "Password ID can't be null") String password, char isActive, Date createAt,
			Date updateAt, String status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.role = role;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", role=" + role
				+ ", username=" + username + ", password=" + password + ", isActive=" + isActive + ", createAt="
				+ createAt + ", updateAt=" + updateAt + ", status=" + status + "]";
	}




}
