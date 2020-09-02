package com.salt.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class UserInfo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String password;

	private String firstName;
	private String lastName;

	private String role;

	public UserInfo(String userName, String password, String role) {
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

}
