package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Appointment;
import com.app.entities.Patient;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	List<Appointment> findByPatientId(Patient patient);
	Page<Appointment> findByDateBetweenAndReport(LocalDate date1,LocalDate date2,String report, Pageable request);
	Page<Appointment> findByDateBetween(LocalDate date1,LocalDate date2, Pageable request);
	Page<Appointment> findByPatientId(Patient patient,Pageable request);
	List<Appointment> findByDateBetween(LocalDate date1,LocalDate date2);

}
