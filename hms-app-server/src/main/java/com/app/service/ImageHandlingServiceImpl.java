package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.UserRepository;
import com.app.dto.UserDto;
import com.app.entities.User;

import lombok.extern.slf4j.Slf4j;
@Service
@Transactional
@Slf4j
public class ImageHandlingServiceImpl implements ImageHandlingService {
	
	@Value("${file.user.uploads}")
	private String folderLocation;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserRepository userRepo;
	@PostConstruct
	public void anyInit() {
		//chk if folder exists -- if not create one
		//java.io.File--> repersents abstract path to a file/folder
		File folder=new File(folderLocation);
		if(!folder.exists())
		{
			folder.mkdirs();
			log.info("folder created");
		
			
		}
		else
			log.info("folder exist already");
	}

	@Override
	public UserDto saveImage(long userId, MultipartFile imgFile) throws IOException {
		User user=userRepo.findById(userId).orElseThrow();
		String path=folderLocation+File.separator+"user"+userId+imgFile.getOriginalFilename();
		log.info("path "+path);
		user.setImagePath(path);//update query upon commit
		//Copy uploaded multipart file to server side folder
		//java.nio.file.Files : copy(InputStream in , Path dest, CopyOptions.. ops)
		//Paths.get(String path) --->  Path
		userRepo.save(user);
			Files.copy(imgFile.getInputStream(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
	
		return mapper.map(user, UserDto.class);
		
		
	}

	@Override
	public byte[] restoreImage(long userId) throws IOException {
		// TODO Auto-generated method stub
		User user=userRepo.findById(userId).orElseThrow();
		String path = user.getImagePath();
		// java.nio.file.Files : public byte[] readAllBytes(Path path) throws IOExc
		if (path != null)
			return Files.readAllBytes(Paths.get(path));
		
		// => image is not yet assigned --throw exc to alert front end
		throw new RuntimeException("Image not  yet assigned , for user " + user.getFirstName());
	}
	
	
}
