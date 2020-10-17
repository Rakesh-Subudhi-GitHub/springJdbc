package com.rk.service;

import java.util.List;
import java.util.Map;

public interface EmployeMgmtService {

	public int fetchEmployeCount();
	public String fetchEmployeName(int empno);
	public Map<String,Object> fetchEmployeDetails_byEmpNo(int empno);

	public List<Map<String,Object>> fetchEmployeDetails_byDesg(String Desg1,String Desg2);
}
