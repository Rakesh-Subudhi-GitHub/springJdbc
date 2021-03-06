package com.rk.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeDAOImpl implements EmployeDAO {

	//sql query
	private static final String Insert_Query="Insert Into EMP(EMPNO,ENAME,JOB,SAL) values(emp_seq.NEXTVAL,?,?,?)";
	
	private JdbcTemplate jt;
	
	public EmployeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
		
	}//constructor

	@Override
	public int insertQuery(String name, String desg, float sal) {
		//read input
		int count=0;
		count=jt.update(Insert_Query,name, desg, sal);
		return count;
	}

}//class
