package com.sistema.hibernate.tarea04.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String sex;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Doctor> doctors = new ArrayList<Doctor>();
	
	public Patient() {
	}

	public Patient(Long id, String name, String sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", sex=" + sex + ", doctors=" + doctors.size() + "]";
	}
}
