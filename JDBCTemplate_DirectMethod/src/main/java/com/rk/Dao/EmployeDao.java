package com.rk.Dao;

import java.util.List;
import java.util.Map;

public interface EmployeDao {

	public int getEmployeCount();
	
	public String getEmpName(int eno);
	
	public Map<String,Object> getEmpdetails(int no);
	
	public List<Map<String,Object>> getEmpDetailsByDesg(String desg1,String desg2);
	
	public int InsertEmp(int eno,String ename,String job,float sal);
	
	public int AddBonus(int eno,int bonus);
}
