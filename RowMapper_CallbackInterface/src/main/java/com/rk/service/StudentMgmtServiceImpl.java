package com.rk.service;

import java.beans.Beans;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.bo.StudentBO;
import com.rk.dao.StudentDAO;
import com.rk.dto.StudentDTO;

@Service("studService")
public class StudentMgmtServiceImpl implements StudentMgmtService {

	@Autowired
	private StudentDAO dao;
	
	@Override
	public StudentDTO fetchStudentByno(int sno) {
	
		StudentBO bo=null;
		StudentDTO dto=null;
		
		//use dao
		bo=dao.getStudentByNo(sno);
		
		//convert StudentBO to StudentDTO
		dto= new StudentDTO();
		
		BeanUtils.copyProperties(bo, dto);
		
		return dto;
	}

}
