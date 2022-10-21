package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.PatientDto;
import com.app.dto.StaffDto;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class FileHandlingServiceForUserRegistrationImpl implements IFileHandlingServiceForUserRegistration {

	@Value("${file.user.uploads}")
	private String imgFolderLocation;
	@Value("${file.upload.degrees}") 
	private String degreeFolderLocation;
	@PostConstruct
	public void anyInit() {
		//chk if folder exists -- if not create one
		//java.io.File--> repersents abstract path to a file/folder
		File imgFolder=new File(imgFolderLocation);
		if(!imgFolder.exists())
		{
			imgFolder.mkdirs();
			log.info("folder for user images created");			
		}
		else
			log.info("folder for user images exist already");
		
		File degreeFolder=new File(degreeFolderLocation);
		if(!degreeFolder.exists())
		{
			degreeFolder.mkdirs();
			log.info("folder for user images created");			
		}
		else
			log.info("folder for user images exist already");
	}
	
	
	
	
	
	@Override
	public String saveStaffImage(StaffDto staffDto, MultipartFile imgFile) throws IOException {
		String path=imgFolderLocation+File.separator+"user"+staffDto.getFirstName()+imgFile.getOriginalFilename();
		log.info("path "+path);
		staffDto.setImagePath(path);//update query upon commit
		//Copy uploaded multipart file to server side folder
		//java.nio.file.Files : copy(InputStream in , Path dest, CopyOptions.. ops)
		//Paths.get(String path) --->  Path
			Files.copy(imgFile.getInputStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);		
		return "Staff Image saved successfully";
	}

	@Override
	public String savePatientImage(PatientDto patientDto, MultipartFile imgFile) throws IOException {
		String path=imgFolderLocation+File.separator+"user"+patientDto.getFirstName()+imgFile.getOriginalFilename();
		log.info("path "+path);
		patientDto.setImagePath(path);//update query upon commit
		//Copy uploaded multipart file to server side folder
		//java.nio.file.Files : copy(InputStream in , Path dest, CopyOptions.. ops)
		//Paths.get(String path) --->  Path
			Files.copy(imgFile.getInputStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);		
		return "Patient Image saved successfully";
	}

	@Override
	public String saveStaffDegreeCertificate(StaffDto staffDto, MultipartFile degreeFile) throws IOException {
		String path=imgFolderLocation+File.separator+"user"+staffDto.getFirstName()+degreeFile.getOriginalFilename();
		log.info("path "+path);
		staffDto.setDegreeCertificatePath(path);//update query upon commit
		//Copy uploaded multipart file to server side folder
		//java.nio.file.Files : copy(InputStream in , Path dest, CopyOptions.. ops)
		//Paths.get(String path) --->  Path
			Files.copy(degreeFile.getInputStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);		
		return "Staff Document saved successfully";
	}

}
