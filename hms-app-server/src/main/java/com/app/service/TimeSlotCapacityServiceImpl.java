package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentTimeSlotRepo;
import com.app.entities.AppointmentTimeSlot;
import com.app.entities.TimeSlots;

@Service
@Transactional
public class TimeSlotCapacityServiceImpl implements ITimeSlotCapacityService {

	@Autowired
	private AppointmentTimeSlotRepo timeSlotRepo;
	
	@Override
	public void refresh() {
		System.out.println("in Refresh");
		long id1=1,id2=5;
		AppointmentTimeSlot todaysSlot = timeSlotRepo.findById(id1).orElseThrow();
		if(todaysSlot.getDate().equals(LocalDate.now()))
			return;
		AppointmentTimeSlot tomorrowsSlot = timeSlotRepo.findById(id2).orElseThrow();
		if(tomorrowsSlot.getDate().equals(LocalDate.now())){
			updateAll();
			return;
		}		
		resetAll();
	}

	@Override
	public void updateAll() {
		System.out.println("in Update");
		List<AppointmentTimeSlot> listOfAllTimeSlots = timeSlotRepo.findAll();
		listOfAllTimeSlots.sort((s1, s2) -> ((Long) s1.getId()).compareTo(s2.getId()));
		/*listOfAllTimeSlots.forEach(slot -> {
			if (slot.getId() == 1) {
				slot.setCapacity(listOfAllTimeSlots.get(4).getCapacity());
				slot.setDate(LocalDate.now());
			} else if (slot.getId() == 2) {
				slot.setCapacity(listOfAllTimeSlots.get(5).getCapacity());
				slot.setDate(LocalDate.now());
			} else if (slot.getId() == 3) {
				slot.setCapacity(listOfAllTimeSlots.get(6).getCapacity());
				slot.setDate(LocalDate.now());
			} else if (slot.getId() == 4) {
				slot.setCapacity(listOfAllTimeSlots.get(7).getCapacity());
				slot.setDate(LocalDate.now());
			} else {
				slot.setDate(LocalDate.now().plusDays(1));
				slot.setCapacity(12);
			}
			});
			*/
			for(int i=0,j=4;i<4;i++,j++) {
				AppointmentTimeSlot slot=	listOfAllTimeSlots.get(i);
					slot.setCapacity(listOfAllTimeSlots.get(j).getCapacity());
					slot.setDate(LocalDate.now());
					slot=listOfAllTimeSlots.get(j);
					slot.setCapacity(12);
					slot.setDate(LocalDate.now().plusDays(1));
			}
		timeSlotRepo.saveAll(listOfAllTimeSlots);
	}

	@Override
	public void resetAll() {
		List<AppointmentTimeSlot> listOfAllTimeSlots = timeSlotRepo.findAll();
		listOfAllTimeSlots.forEach(slot -> {
			slot.setCapacity(12);
			if (slot.getId()<=4) {

				slot.setDate(LocalDate.now());

			} else {
				slot.setDate(LocalDate.now().plusDays(1));
			}
			timeSlotRepo.saveAll(listOfAllTimeSlots);
		});
	}

	@Override
	public String bookTimeSlot(LocalDate date, TimeSlots timeSlot) {
		AppointmentTimeSlot appointmentSlot = timeSlotRepo.findByDateAndTimeSlot(date, timeSlot).orElseThrow();
		appointmentSlot.setCapacity(appointmentSlot.getCapacity()-1);
		timeSlotRepo.save(appointmentSlot);
		return "Appointment Booked!!!";
	}

	@Override
	public int getAvailableCapacity(LocalDate date, TimeSlots timeSlot) {
		AppointmentTimeSlot appointmentSlot = timeSlotRepo.findByDateAndTimeSlot(date, timeSlot).orElseThrow();
		return appointmentSlot.getCapacity();
	}

	@Override
	public String bookTimeSlot(long id) {
		AppointmentTimeSlot appointmentSlot =timeSlotRepo.findById(id).orElseThrow();
		appointmentSlot.setCapacity(appointmentSlot.getCapacity()-1);
		timeSlotRepo.save(appointmentSlot);
		return "Appointment Booked!!!";
	}

	@Override
	public int getAvailableCapacity(long id) {
		AppointmentTimeSlot appointmentSlot =timeSlotRepo.findById(id).orElseThrow();
		return appointmentSlot.getCapacity();
	}

	@Override
	public List<AppointmentTimeSlot> getTimeSlots() {
		
		return timeSlotRepo.findAll();
	}

	@Override
	public boolean dateAndTimeSlotOk(LocalDate date, TimeSlots timeSlot) {
		//to check if older date
		
		if(date.equals(LocalDate.now().plusDays(1))) {
			
			return true;
		}
		if(date.equals(LocalDate.now())) 
		{
			
			//if appointment is for today then check time slot,bookings allowed not allowed  for current or old time slots
			// In morning slot one cannot book morning appointment and in evening also one cannot book morning slot
			if(date.equals(LocalDate.now())) {   
				int time=LocalTime.now().getHour();  // 0 to 23
				if(time>=21 &&(timeSlot==TimeSlots.MORNING||timeSlot==TimeSlots.AFTERNOON||timeSlot==TimeSlots.EVENING||timeSlot==TimeSlots.NIGHT))
					return false;
				if(time>=18 &&(timeSlot==TimeSlots.MORNING||timeSlot==TimeSlots.AFTERNOON||timeSlot==TimeSlots.EVENING))
					return false;
				if(time>=15 &&(timeSlot==TimeSlots.MORNING||timeSlot==TimeSlots.AFTERNOON))
					return false;
				
				if(time>=8 && timeSlot==TimeSlots.MORNING) 
					return false;				
			}				
			//For Tomorrow all slots available
			return true;
		}
		//old date 
		
		return false;
	}

	
}
