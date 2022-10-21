package com.app.service;

import java.util.List;

import com.app.dto.StaffScheduleDto;
import com.app.dto.UserDto;
import com.app.entities.Admin;

public interface IAdminService {
	
	public Admin getAdminByEmail(String email);
	
	public Admin addNewAdmin(UserDto newAdmin);
	
	public List<StaffScheduleDto> getStaffList(int pageNo,int pageSize);
	
	public List<StaffScheduleDto> getStaffList();

	
}
