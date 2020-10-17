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

	@Override
	public String putBonus(String desg, float bouns) {
		int count;
		count=dao.addBonus(desg, bouns);
		
		return count==0?"emp not found or not add bouns":count+"emp bouns added or update sal";
	}

}//class
