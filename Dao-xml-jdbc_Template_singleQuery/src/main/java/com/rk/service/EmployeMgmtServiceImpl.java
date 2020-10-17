package com.rk.service;

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

}//class
