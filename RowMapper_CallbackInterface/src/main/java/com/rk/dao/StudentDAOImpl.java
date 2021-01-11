package com.rk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rk.bo.StudentBO;

@Repository("studDAO")
public class StudentDAOImpl implements StudentDAO {

	//sql
	private static final String Select_Query="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SNO=?";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public StudentBO getStudentByNo(int sno) {
		
		StudentBO bo=null;
		
		//execute query
		bo=jt.queryForObject(Select_Query,
															new StudentMapper(),  //calling or load inner class
																			sno  //set param values
											);	//collect all data in bo and return back to all details
		
		return bo;
	}//method

	//inner class
	private  static class StudentMapper implements RowMapper<StudentBO>{

		@Override
		public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			//convert RS record to StudentBO class object
			StudentBO bo=new StudentBO();
			
			//collect one by one column value
			bo.setSno(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSadd(rs.getString(3));
			bo.setAvg(rs.getFloat(4));
			
			return bo;
		}//method
		
	}//inner class
	
}//outer class
