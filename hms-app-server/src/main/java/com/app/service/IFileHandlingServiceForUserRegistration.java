package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.PatientDto;
import com.app.dto.StaffDto;

public interface IFileHandlingServiceForUserRegistration {

	String saveStaffImage(StaffDto staffDto,MultipartFile imgFile)throws IOException ;
	String savePatientImage(PatientDto patientDto,MultipartFile imgFile)throws IOException ;
	String saveStaffDegreeCertificate(StaffDto staffDto,MultipartFile degreeFile)throws IOException ;
}
