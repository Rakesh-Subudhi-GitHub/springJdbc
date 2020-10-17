package com.rk.service;

import java.util.List;
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

	@Override
	public List<Map<String, Object>> fetchEmployeDetails_byDesg(String Desg1, String Desg2) {
		
		return dao.getEmpDetails_by_Desg(Desg1, Desg2);
	}

}//class
