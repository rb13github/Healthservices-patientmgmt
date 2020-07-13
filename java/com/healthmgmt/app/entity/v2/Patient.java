package com.healthmgmt.app.entity.v2;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;


@Entity
@Table(name="patient",schema = "public")
public class Patient {

	@Column(name ="id")
	private Long id;
	private String mobile;
	private String name;
	private String age;
	private String address;
	private int quarantine_duration;
	private boolean covidpatient;

	/*Constructors*/
	public Patient() {

	}

	public Patient(Long id, String name, String mobile,String age,String address,int quarantine_duration,boolean iscovidPatient ) {

		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.age=age;
		this.address=address;
		this.quarantine_duration=quarantine_duration;
		this.covidpatient=iscovidPatient;
	}

	
	/* Getters and Setters*/
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getQuarantine_duration() {
		return quarantine_duration;
	}

	public void setQuarantine_duration(int quarantine_duration) {
		this.quarantine_duration = quarantine_duration;
	}

	public boolean isCovidPatient() {
		return covidpatient;
	}

	public void setCovidPatient(boolean covidPatient) {
		this.covidpatient = covidPatient;
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
