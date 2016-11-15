package com.sistema.hibernate.tarea04.dao;

import java.util.List;

import com.sistema.hibernate.tarea04.model.Patient;

public interface PatientDAO {

	public Patient selectById(Long id);

	public List<Patient> selectAll();

	public void insert(Patient patient);

	public void update(Patient patient);

	public void delete(Patient patient);

}
