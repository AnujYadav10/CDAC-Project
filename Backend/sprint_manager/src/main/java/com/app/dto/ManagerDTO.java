package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.app.entities.Position;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class ManagerDTO {
	
	@JsonProperty(access = Access.READ_ONLY) //used during serialization
	private Long id;
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private LocalDate joinDate;
	@NotBlank
	private Position Position; 
	
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public Long getId() {
		return id;
	}
	public Position getPosition() {
		return Position;
	}
	public void setPosition(Position position) {
		Position = position;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ManagerDTO [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	public ManagerDTO(Long id, @NotBlank String email, @NotBlank String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public ManagerDTO() {
		super();
	}

	
	
}
