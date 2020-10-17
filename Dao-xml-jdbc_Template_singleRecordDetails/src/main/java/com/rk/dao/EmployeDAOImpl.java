package com.rk.dao;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeDAOImpl implements EmployeDAO {

	//sql query
	private static final String Get_count_Emp="SELECT COUNT(*) FROM EMP";
	private static final String Get_EmpName_By_Eno="SELECT ENAME FROM EMP WHERE EMPNO = ?";
	private static final String Get_EmpDetails_By_Eno="SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE EMPNO = ?";
	
	private JdbcTemplate jt;
	
	public EmployeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
		
	}//constructor

	@Override
	public int getEmployeCount() {
		
		//read inputs
		int count=0;
		
		count=jt.queryForObject(Get_count_Emp,Integer.class);//integer value required	 need long then long.class integer so say integer.class
		
		return count;
		
	}//method

	@Override
	public String getEmpNameByName(int empno) {
		
		//read inputs
		String name=null;
		
		name=jt.queryForObject(Get_EmpName_By_Eno, String.class,empno);//eno to take this String Ename
		return name;
	}//method

	@Override
	public Map<String, Object> getSingleEmpDetails(int empno) {
		
		//read inputs
		Map<String, Object> map=null;//bcz all are string integer or float i dont know what the flo so get super class of all 
								//so i take object
		
		map=jt.queryForMap(Get_EmpDetails_By_Eno,empno);
		
		return map;
	}

}//class
