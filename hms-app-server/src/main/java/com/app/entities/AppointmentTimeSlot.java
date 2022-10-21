package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentTimeSlot extends BaseEntity{
	@NotNull
	private LocalDate date;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Day day;
	@Enumerated(EnumType.STRING)
	@NotNull
	private TimeSlots timeSlot;
	@NotNull
	private Integer capacity;
	@Enumerated(EnumType.STRING)
	@NotNull
	private TimeSlotStatus status;
	
	//stored procedure 
	//refresh_Time_Slots_Capacity()
	//refresh_Time_Slots_Capacity_All()
	
}
