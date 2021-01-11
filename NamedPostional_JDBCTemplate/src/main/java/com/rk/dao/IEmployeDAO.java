package com.rk.dao;

import java.util.List;

import com.rk.bo.EmployeBO;

public interface IEmployeDAO {

	public String getEmpDetailsByEmpno(int Empno);
	
	public List<EmployeBO> getEmployeDetailsByDesg(String Desg);
}
