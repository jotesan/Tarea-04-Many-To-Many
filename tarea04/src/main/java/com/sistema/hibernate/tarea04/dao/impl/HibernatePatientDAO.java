package com.sistema.hibernate.tarea04.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sistema.hibernate.tarea04.HibernateSession;
import com.sistema.hibernate.tarea04.model.Patient;
import com.sistema.hibernate.tarea04.dao.PatientDAO;

public class HibernatePatientDAO implements PatientDAO {

	public Patient selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Patient patient = (Patient) session.get(Patient.class, id);
		session.close();
		return patient;
	}

	public List<Patient> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Patient> patients = session.createCriteria(Patient.class).list();
		session.close();
		return patients;
	}

	public void insert(Patient patient) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(patient);
		patient.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Patient patient) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(patient);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Patient patient) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(patient);
		session.getTransaction().commit();
		session.close();
	}
}
