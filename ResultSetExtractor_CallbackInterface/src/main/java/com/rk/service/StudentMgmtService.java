package com.rk.service;

import java.util.List;

import com.rk.dto.StudentDTO;

public interface StudentMgmtService {

	public StudentDTO fetchStudentByno(int sno);
	
	public List<StudentDTO> fetchStudentByCity(String city1,String city2);
}
