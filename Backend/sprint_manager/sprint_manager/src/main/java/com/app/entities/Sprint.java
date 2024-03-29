package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;


@Entity
@Table(name = "Sprint")
public class Sprint extends BaseEntity {

	@Column
	private String Domain;
	@Column
	private String Priority;
	@Column(name="Deadline")
	private LocalDate deadline;
	@Column(length = 30,name="No_of_employees")
	private int number_emp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id") // Optional BUT reco , to specify the name of FK col.
	private Manager  mang;

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



	public Manager getMang() {
		return mang;
	}

	public void setMang(Manager mang) {
		this.mang = mang;
	}

	public Sprint(String domain, String priority, LocalDate last_date_to_submit, int number_emp) {
		super();
		Domain = domain;
		Priority = priority;
		deadline = last_date_to_submit;
		this.number_emp = number_emp;
	}



	public Sprint(String domain, String priority, LocalDate last_date_to_submit, int number_emp, Manager mang) {
		super();
		Domain = domain;
		Priority = priority;
		deadline = last_date_to_submit;
		this.number_emp = number_emp;
		this.mang = mang;
	}

	public Sprint() {
		super();
	}

	@Override
	public String toString() {
		return "Sprint [Domain=" + Domain + ", Priority=" + Priority + ", Last_date_to_submit=" + deadline
				+ ", number_emp=" + number_emp + "]";
	}
	
	
	
}
