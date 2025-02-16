package com.athira.demo.service;

import java.util.List;

import com.athira.demo.common.APIResponse;
import com.athira.demo.dto.LoginRequestDTO;
import com.athira.demo.dto.SignUpRequestDto;
import com.athira.demo.entity.Staff;
import com.athira.demo.entity.User;

public interface ILoginService {
	
	List<Staff> getAllAttendance();

	APIResponse signUp(SignUpRequestDto signUpRequestDto);

	APIResponse login(LoginRequestDTO loginRequestDTO);

}
