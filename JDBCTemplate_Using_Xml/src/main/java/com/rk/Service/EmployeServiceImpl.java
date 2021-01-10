package com.rk.Service;

import com.rk.Dao.EmployeDao;

public class EmployeServiceImpl implements EmployeService {

	private EmployeDao edao;
	
	public EmployeServiceImpl(EmployeDao edao) {
		System.out.println("1-param constructor for EmployeService class ");
		this.edao = edao;
	}

	@Override
	public int fetchEmployeCount() {
		
		//calling EmployeDao method and return value
		return edao.getEmployeCount();
	}//method

}//class
