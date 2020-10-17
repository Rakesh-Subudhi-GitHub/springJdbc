package com.rk.service;

import java.util.Map;

import com.rk.dao.EmployeDAO;

public class EmployeMgmtServiceImpl implements EmployeMgmtService {

	private EmployeDAO dao;
	
	public EmployeMgmtServiceImpl(EmployeDAO dao) {
		this.dao = dao;
	}

	@Override
	public int fetchEmployeCount() {
		
		return dao.getEmployeCount();//calling method 
	}//method

	@Override
	public String fetchEmployeName(int empno) {
		
		return dao.getEmpNameByName(empno);//dao method calling
	}

	@Override
	public Map<String, Object> fetchEmployeDetails_byEmpNo(int empno) {
		
		return dao.getSingleEmpDetails(empno);
	}

}//class
