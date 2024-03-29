package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.app.entities.*;
@Entity
@Table(name = "manager")

public class Manager extends BaseEntity {
	@Column(name = "email", length = 40)
	private String email;
	@Column(length = 30)
	private String password;	
	@Column(name="first_name",length = 30)
	private String firstName;
	@Column(name="last_name",length = 30)
	private String lastName;
	@Column(name="join_date")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING) 
	@Column(length = 30,name="Position")
	private Position Position; 
	@Column(nullable = true)
	private double salary;
		
	@OneToMany(mappedBy = "mang" , cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Sprint> sprintlist = new ArrayList<>();
	
	
	public void addSprint(Sprint e) {
		sprintlist.add(e);// dept --> emp
		e.setMang(this);// emp --> dept
	}
	public void removeEmployee(Sprint e) {
		sprintlist.remove(e);
		e.setMang(null);
	}
	
	public List<Sprint> getSprintlist() {
		return sprintlist;
	}
	public void setSprintlist(List<Sprint> sprintlist) {
		this.sprintlist = sprintlist;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Manager [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", joinDate=" + joinDate + ", Position=" + Position + ", salary=" + salary + "]";
	}
	public Manager(String email, String password, String firstName, String lastName) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Manager() {
		super();
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public Position getPosition() {
		return Position;
	}
	public void setPosition(Position position) {
		Position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
