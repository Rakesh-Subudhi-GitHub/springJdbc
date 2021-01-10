package com.rk.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeDaoImpl implements EmployeDao{

	//sql
	private static final String CountQuery="SELECT COUNT(*) FROM EMP";
	
	//properties
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int getEmployeCount() {
		
		//Properties
		int count=0;
		
		count=jt.queryForObject(CountQuery,Integer.class);
		
		//return the count
		return count;
		
	}//method

}//class
