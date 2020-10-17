package com.rk.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeDAOImpl implements EmployeDAO {

	//sql query
	private static final String Get_count_Emp="SELECT COUNT(*) FROM EMP";
	
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

}//class
