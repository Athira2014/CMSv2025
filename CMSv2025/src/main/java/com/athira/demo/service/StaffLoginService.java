package com.athira.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athira.demo.common.APIResponse;
import com.athira.demo.dao.IStaffLoginDao;
import com.athira.demo.dto.SignUpRequestDto;
import com.athira.demo.entity.StaffLogin;

@Service
public class StaffLoginService implements IStaffLoginService {
	
	// Not using stafflogin anymore instead user User

	
//	@Autowired
//	IStaffLoginDao staffLoginDao;
//
//	@Transactional
//	public List<StaffLogin> getAllAttendance() {
//		return staffLoginDao.findAll();
//	}
//
//	public APIResponse signUp(SignUpRequestDto signUpRequestDto) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
