package com.sistema.hibernate.tarea04;

import java.util.List;

import com.sistema.hibernate.tarea04.dao.impl.HibernateDoctorDAO;
import com.sistema.hibernate.tarea04.dao.impl.HibernatePatientDAO;
import com.sistema.hibernate.tarea04.model.Doctor;
import com.sistema.hibernate.tarea04.model.Patient;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {
		Doctor doctor1 = new Doctor(1L, "Gregory House", "diagnosticate");
		Doctor doctor2 = new Doctor(2L, "Stephen Strange", "Magic");
		
		Patient patient1 = new Patient(1L, "James Wilson", "Male");
		Patient patient2 = new Patient(2L, "Karl Mordo", "Male");
		
		doctor1.addPatient(patient1);
		doctor2.addPatient(patient2);
		
		patient1.addDoctor(doctor1);
		patient2.addDoctor(doctor2);
		
		HibernateDoctorDAO hibernateDoctorDAO = new HibernateDoctorDAO();
		HibernatePatientDAO hibernatePatientDAO = new HibernatePatientDAO();
		
		hibernateDoctorDAO.insert(doctor1);
		hibernateDoctorDAO.insert(doctor2);
		
		hibernatePatientDAO.insert(patient1);
		hibernatePatientDAO.insert(patient2);
		
		List<Doctor> doctors = hibernateDoctorDAO.selectAll();
		System.out.println(doctors);
		
		List<Patient> patients = hibernatePatientDAO.selectAll();
		System.out.println(patients);
	}
}
