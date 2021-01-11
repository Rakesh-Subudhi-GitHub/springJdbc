package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.dao.IEmployeDAO;

@Service("empService")
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	private IEmployeDAO dao;
	
	@Override
	public String featchEmployeDetailsByEmpno(int empno) {
		
		//use DAO
		String empDetails=dao.getEmpDetailsByEmpno(empno);
		
		return empDetails;
		
	}//method

}
