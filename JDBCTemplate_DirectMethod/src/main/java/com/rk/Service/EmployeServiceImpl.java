package com.rk.Service;

import java.util.List;
import java.util.Map;

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

	@Override
	public String fetchEmployeName(int eno) {
		
		//calling empDao method with eno also
		return edao.getEmpName(eno);
	}

	@Override
	public Map<String, Object> fetchEmpDetails(int no) {
		
		//calling Dao class
		return edao.getEmpdetails(no);
	}

	@Override
	public List<Map<String, Object>> fetchEmpDetailsByDesg(String desg1, String desg2) {
		
		//calling Dao class
		return edao.getEmpDetailsByDesg(desg1, desg2);
	}

	@Override
	public int fetchInsertEmp(int eno, String ename, String job, float sal) {
		
		//calling DAO
		return edao.InsertEmp(eno, ename, job, sal);
	}

	@Override
	public int fetchAddBonus(int eno, int bonus) {
		
		//calling DAO
		return edao.AddBonus(eno, bonus);
	}

}//class
