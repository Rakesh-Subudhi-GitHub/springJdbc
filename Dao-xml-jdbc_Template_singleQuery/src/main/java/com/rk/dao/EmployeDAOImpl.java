package com.rk.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeDAOImpl implements EmployeDAO {

	//sql query
	private static final String Get_count_Emp="SELECT COUNT(*) FROM EMP";
	private static final String Get_EmpName_By_Eno="SELECT ENAME FROM EMP WHERE EMPNO = ?";
	//select ename from emp where empno=7499;
	
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

}//class
