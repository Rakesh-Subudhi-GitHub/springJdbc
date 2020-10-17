package com.rk.service;

import com.rk.dao.EmployeDAO;

public class EmployeMgmtServiceImpl implements EmployeMgmtService {

	private EmployeDAO dao;
	
	public EmployeMgmtServiceImpl(EmployeDAO dao) {
		this.dao = dao;
	}

	@Override
	public String registerEmp(String name, String desg, float sal) {
	
		//read inputs
		int count=0;
		count=dao.insertQuery(name, desg, sal);
		
		return count==0?"Register failed":"Register succesfully";
	}

}//class
