package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.AddressDto;
import com.app.dto.AppointmentDto;
import com.app.dto.PatientDto;
import com.app.dto.UpdateUserDetailsDto;
import com.app.entities.Appointment;

public interface IPatientService {

	public PatientDto addPatientDetails(PatientDto patient,AddressDto addressDto,MultipartFile imgFile) throws IOException;
		
	public AddressDto getPatientDetails(long patId);

	public AddressDto updatePatientDetails(long patId,UpdateUserDetailsDto patientDto,AddressDto addressDto);
	
	public byte[] downloadReport(long aptId) throws IOException;

	public List<Appointment> getReportList(long patId); 
	String bookAppointment(AppointmentDto newAppointment,long patId);
	String setPlan(long patId,String plan);
	List<Appointment> getReportList(long patId,int pageNo,int pageSize); 


	
}
