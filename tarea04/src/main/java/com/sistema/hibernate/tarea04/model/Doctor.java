package com.sistema.hibernate.tarea04.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String area;
	
	@ManyToMany(mappedBy = "doctors")
	private List<Patient> patients = new ArrayList<Patient>();
	
	public Doctor() {
	}

	public Doctor(Long id, String name, String area) {
		this.id = id;
		this.name = name;
		this.area = area;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	public void addPatient(Patient patient) {
		patients.add(patient);
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", area=" + area + ", patients=" + patients.size() + "]";
	}
	
	
}
