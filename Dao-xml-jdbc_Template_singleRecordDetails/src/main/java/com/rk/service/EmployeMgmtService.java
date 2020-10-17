package com.rk.service;

import java.util.Map;

public interface EmployeMgmtService {

	public int fetchEmployeCount();
	public String fetchEmployeName(int empno);
	public Map<String,Object> fetchEmployeDetails_byEmpNo(int empno);

}
