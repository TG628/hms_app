package com.app.service;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentTimeSlotRepo;
import com.app.entities.AppointmentTimeSlot;
import com.app.entities.Day;
import com.app.entities.TimeSlotStatus;
import com.app.entities.TimeSlots;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j

public class AppointmentTimeSlotService {
	
	@Autowired
	private AppointmentTimeSlotRepo timeSlotRepo;
	
	@PostConstruct
	public void anyInit() {
		try {
		timeSlotRepo.findById((long)1).orElseThrow();
			return;
		}
		catch(Exception e){
			
			timeSlotRepo.save( new AppointmentTimeSlot(LocalDate.now(),Day.TODAY,TimeSlots.MORNING,12,TimeSlotStatus.AVAILABLE));
			timeSlotRepo.save( new AppointmentTimeSlot(LocalDate.now(),Day.TODAY,TimeSlots.AFTERNOON,12,TimeSlotStatus.AVAILABLE));
			timeSlotRepo.save( new AppointmentTimeSlot(LocalDate.now(),Day.TODAY,TimeSlots.EVENING,12,TimeSlotStatus.AVAILABLE));
			timeSlotRepo.save( new AppointmentTimeSlot(LocalDate.now(),Day.TODAY,TimeSlots.NIGHT,12,TimeSlotStatus.AVAILABLE));
			timeSlotRepo.save( new AppointmentTimeSlot(LocalDate.now().plusDays(1),Day.TOMORROW,TimeSlots.MORNING,12,TimeSlotStatus.AVAILABLE));
			timeSlotRepo.save( new AppointmentTimeSlot(LocalDate.now().plusDays(1),Day.TOMORROW,TimeSlots.AFTERNOON,12,TimeSlotStatus.AVAILABLE));
			timeSlotRepo.save( new AppointmentTimeSlot(LocalDate.now().plusDays(1),Day.TOMORROW,TimeSlots.EVENING,12,TimeSlotStatus.AVAILABLE));
			timeSlotRepo.save( new AppointmentTimeSlot(LocalDate.now().plusDays(1),Day.TOMORROW,TimeSlots.NIGHT,12,TimeSlotStatus.AVAILABLE));
			log.info("Application time slot table created");
		}
			
		
		
		
	}

}
