package com.sistema.hibernate.tarea04.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sistema.hibernate.tarea04.HibernateSession;
import com.sistema.hibernate.tarea04.dao.DoctorDAO;
import com.sistema.hibernate.tarea04.model.Doctor;

public class HibernateDoctorDAO implements DoctorDAO {

	public Doctor selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Doctor doctor = (Doctor) session.get(Doctor.class, id);
		session.close();
		return doctor;
	}

	public List<Doctor> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Doctor> doctor = session.createCriteria(Doctor.class).list();
		session.close();
		return doctor;
	}

	public void insert(Doctor doctor) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(doctor);
		doctor.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Doctor doctor) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(doctor);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Doctor doctor) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(doctor);
		session.getTransaction().commit();
		session.close();
	}
}
