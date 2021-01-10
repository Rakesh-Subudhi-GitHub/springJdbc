package com.rk.Service;

import java.util.List;
import java.util.Map;

public interface EmployeService {

	public int fetchEmployeCount();
	
	public String fetchEmployeName(int eno);

	public Map<String,Object> fetchEmpDetails(int no);
	
	public List<Map<String,Object>> fetchEmpDetailsByDesg(String desg1,String desg2);
	
	public int fetchInsertEmp(int eno,String ename,String job,float sal);
	
	public int fetchAddBonus(int eno,int bonus);
}
