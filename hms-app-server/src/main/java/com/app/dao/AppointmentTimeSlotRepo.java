package com.app.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AppointmentTimeSlot;
import com.app.entities.TimeSlots;

public interface AppointmentTimeSlotRepo extends JpaRepository<AppointmentTimeSlot, Long> {
	
	Optional<AppointmentTimeSlot> findByDateAndTimeSlot(LocalDate date, TimeSlots timeSlot);
	
}
