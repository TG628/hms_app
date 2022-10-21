package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IBDSClientService {

	
	List<?> getDonorList(String bloodGroup,int pinCode,int pageSize,int pageNo);
}
