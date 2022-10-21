package com.app.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.ApplicationRepository;
import com.app.dto.ApplicationDto;
import com.app.entities.Application;
import com.app.entities.ApplicationStatus;

@Service
@Transactional
public class ApplicationServiceImpl implements IApplicationService {

	@Autowired
	private ApplicationRepository applnRepo;
	@Autowired 
	private ModelMapper mapper;
	@Autowired
	private ResumeDocHandlingServiceImpl resumeService;
	@Override
	public ApplicationDto saveApplication(ApplicationDto applnDto,MultipartFile resumeFile) throws IOException {
		Application appln=mapper.map(applnDto, Application.class);
		appln.setStatus(ApplicationStatus.PENDING);
		applnRepo.save(appln);
		resumeService.uploadResume(appln.getId(), resumeFile);
		return applnDto;
	}

	@Override
	public List<Application> getAllApplications(int pageNo,int pageSize) {
		
		
					Pageable request = PageRequest.of(pageNo, pageSize);
					//Pageable request = PageRequest.of(pageNo, pageSize);
					Page<Application> page = applnRepo.findByStatus(ApplicationStatus.PENDING,request);						 
					return page.getContent();
	}

	@Override
	public String updateStatus(long applnId) {
		Application appln = applnRepo.findById(applnId).orElseThrow();
		appln.setStatus(ApplicationStatus.SEEN);
		applnRepo.save(appln);
		return "Application status changed";
	}

	@Override
	public byte[] downloadResume(long applnId) throws IOException {
		
		return resumeService.downloadResume(applnId);
	}

}
