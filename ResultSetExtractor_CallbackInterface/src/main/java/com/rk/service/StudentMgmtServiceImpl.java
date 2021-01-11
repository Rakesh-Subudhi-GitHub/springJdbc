package com.rk.service;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<StudentDTO> fetchStudentByCity(String city1, String city2) {
		
		List<StudentBO> listbo=null;
		List<StudentDTO> listdto=new ArrayList();
		
		//use dao
		listbo=dao.getStudentByCity(city1, city2);
		
		//convert StudentBO to StudentDTO
		
		listbo.forEach(bo->{
							StudentDTO dto=new StudentDTO();
							BeanUtils.copyProperties(bo, dto);   //per bo is comes copy to dto each
							
							//add listdto
							listdto.add(dto);
		});
		
		//return listDTO
		return listdto;
	}

}
