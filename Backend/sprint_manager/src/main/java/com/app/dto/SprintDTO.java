package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.app.entities.Position;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class SprintDTO {

	@JsonProperty(access = Access.READ_ONLY) //used during serialization
	private Long id;
	@NotBlank
	private String Domain;
	@NotBlank
	private String Priority;
	@NotBlank
	private LocalDate deadline;
	@NotBlank
	private int number_emp;
	@JsonProperty(access = Access.WRITE_ONLY) // used during de-serialization
	private Long manager_id;
	public SprintDTO(Long id, @NotBlank String domain, @NotBlank String priority,
			@NotBlank LocalDate deadline, @NotBlank int number_emp, Long manager_id) {
		super();
		this.id = id;
		Domain = domain;
		Priority = priority;
		deadline = deadline;
		this.number_emp = number_emp;
		this.manager_id = manager_id;
	}
	public Long getManager_id() {
		return manager_id;
	}
	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDomain() {
		return Domain;
	}
	public void setDomain(String domain) {
		Domain = domain;
	}
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String priority) {
		Priority = priority;
	}
	public LocalDate getLast_date_to_submit() {
		return deadline;
	}
	public void setLast_date_to_submit(LocalDate last_date_to_submit) {
		deadline = last_date_to_submit;
	}
	public int getNumber_emp() {
		return number_emp;
	}
	public void setNumber_emp(int number_emp) {
		this.number_emp = number_emp;
	}
	public SprintDTO(Long id, @NotBlank String domain, @NotBlank String priority,
			@NotBlank LocalDate last_date_to_submit, @NotBlank int number_emp) {
		super();
		this.id = id;
		Domain = domain;
		Priority = priority;
		deadline = last_date_to_submit;
		this.number_emp = number_emp;
	}
	public SprintDTO() {
		super();
	}
	@Override
	public String toString() {
		return "SprintDTO [id=" + id + ", Domain=" + Domain + ", Priority=" + Priority + ", Last_date_to_submit="
				+ deadline + ", number_emp=" + number_emp + "]";
	} 
	
	
	
}
