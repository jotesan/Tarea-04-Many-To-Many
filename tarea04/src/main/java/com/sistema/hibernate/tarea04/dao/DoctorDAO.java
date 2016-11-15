package com.sistema.hibernate.tarea04.dao;

import java.util.List;

import com.sistema.hibernate.tarea04.model.Doctor;

public interface DoctorDAO {

	public Doctor selectById(Long id);

	public List<Doctor> selectAll();

	public void insert(Doctor doctor);

	public void update(Doctor doctor);

	public void delete(Doctor doctor);

}
