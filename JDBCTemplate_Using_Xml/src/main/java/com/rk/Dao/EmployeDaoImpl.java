package com.rk.Dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeDaoImpl implements EmployeDao{

	//sql
	private static final String CountQuery="SELECT COUNT(*) FROM EMP";
	
	//properties
	private JdbcTemplate jt;
	
	//constructor
	public EmployeDaoImpl(JdbcTemplate jt) {
		System.out.println("1-param constructor calling in EmployeDao class");
		this.jt = jt;
	}
	
	@Override
	public int getEmployeCount() {
		
		//Properties
		int count=0;
		
		count=jt.queryForObject(CountQuery,Integer.class);
		
		//return the count
		return count;
		
	}//method

}//class
