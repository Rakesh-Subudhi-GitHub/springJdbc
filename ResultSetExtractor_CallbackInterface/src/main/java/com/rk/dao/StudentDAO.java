package com.rk.dao;

import java.util.List;

import com.rk.bo.StudentBO;

public interface StudentDAO {

	public StudentBO getStudentByNo(int sno);
	
	public List<StudentBO> getStudentByCity(String city1,String city2);
	
}
