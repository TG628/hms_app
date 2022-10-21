package com.app.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Application;
import com.app.entities.ApplicationStatus;

public interface ApplicationRepository  extends JpaRepository<Application, Long> {
	List<Application> findAll();
	Page<Application> findByStatus(ApplicationStatus status,Pageable request);
}
