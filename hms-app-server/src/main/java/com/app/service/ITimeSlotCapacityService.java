package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.AppointmentTimeSlot;
import com.app.entities.TimeSlots;

public interface ITimeSlotCapacityService {
	
	void resetAll();
	void updateAll();
	String bookTimeSlot(LocalDate date,TimeSlots timeSlot); 
	int getAvailableCapacity(LocalDate date,TimeSlots timeSlot);
	String bookTimeSlot(long id); 
	int getAvailableCapacity(long id);
	void refresh();
	public List<AppointmentTimeSlot> getTimeSlots();
	boolean dateAndTimeSlotOk(LocalDate date,TimeSlots timeSlot);
}
