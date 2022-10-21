package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.app.entities.TimeSlots;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AppointmentDto {

	@NotNull(message = "Appointment date cannot be blank")
	private LocalDate date;
	@NotNull(message = "Time Slot cannot be blank")
	private TimeSlots timeSlot;
	@NotNull(message = "Doctor must not be null")
	private long docId;
	@JsonProperty(access = Access.READ_ONLY)
	private String report;

}
