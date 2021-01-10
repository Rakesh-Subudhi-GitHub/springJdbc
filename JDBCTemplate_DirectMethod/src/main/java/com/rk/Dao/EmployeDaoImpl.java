package com.rk.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeDaoImpl implements EmployeDao{

	//sql
	private static final String CountQuery="SELECT COUNT(*) FROM EMP";
	private static final String EmpName="SELECT ENAME FROM EMP WHERE EMPNO=?";
	private static final String EmpDetails="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String EmpDetailsByDesg="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?)";
	private static final String InsertEmp="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(?,?,?,?)";
	private static final String AddBouns="UPDATE EMP SET SAL=SAL+? WHERE EMPNO=?";
	
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
		
		//execute query
		count=jt.queryForObject(CountQuery,Integer.class);
		
		//return the count
		return count;
		
	}//method

	@Override
	public String getEmpName(int eno) {
		
		//properties
		String name=null;
		
		//execute query
		name=jt.queryForObject(EmpName, String.class,eno);//just bcz "?" value should be insert
		
		//return name
		return name;
	}

	@Override
	public Map<String, Object> getEmpdetails(int no) {
		
		//properties
		Map<String, Object> map=null;
		
		//execute query
		map=jt.queryForMap(EmpDetails,no);
		
		//return Emp details
		return map;
	}

	@Override
	public List<Map<String, Object>> getEmpDetailsByDesg(String desg1,String desg2) {
		
		//properties
		List<Map<String, Object>> list=null;
		
		//execute query
		list=jt.queryForList(EmpDetailsByDesg,desg1,desg2);
		
		//return list
		return list;
	}

	@Override
	public int InsertEmp(int eno, String ename, String job, float sal) {
		
		//properties
		int count=0;
		
		//execute query
		count=jt.update(InsertEmp,eno,ename,job,sal);
		
		//return
		return count;
	}

	@Override
	public int AddBonus(int eno, int bonus) {
		
		//properties
		int count=0;
		
		//execute query
		count=jt.update(AddBouns,bonus,eno);
		
		return count;
	}

}//class
