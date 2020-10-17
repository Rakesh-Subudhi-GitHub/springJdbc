package com.rk.dao;

import java.util.Map;

public interface EmployeDAO {

	public int getEmployeCount();
	public String getEmpNameByName(int empno);
	
	public Map<String,Object> getSingleEmpDetails(int empno);
}
