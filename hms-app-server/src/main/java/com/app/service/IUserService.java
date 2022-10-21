package com.app.service;

import java.util.List;

import com.app.dto.AddressDto;
import com.app.dto.PasswordDto;
import com.app.entities.AppointmentTimeSlot;
import com.app.entities.Staff;

public interface IUserService {

	 String saveAddress(long userId,AddressDto addressDto);
	 List<AppointmentTimeSlot> getTimeSlots();
	 AddressDto updateAddress(long patId, AddressDto addressDto);
	 AddressDto getAddress(long pathId);
	String changePassword(long userId, PasswordDto password);
	List<Staff> getDoctorsList();
	
}
