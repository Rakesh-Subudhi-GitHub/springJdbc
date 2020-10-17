package com.rk.dao;

import java.util.List;
import java.util.Map;

public interface EmployeDAO {

	public int getEmployeCount();
	public String getEmpNameByName(int empno);
	
	public Map<String,Object> getSingleEmpDetails(int empno);
	
	public List<Map<String,Object>> getEmpDetails_by_Desg(String Desg1,String Desg2);
}
