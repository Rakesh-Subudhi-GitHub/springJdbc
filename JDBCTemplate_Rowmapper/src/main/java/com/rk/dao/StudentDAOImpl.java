package com.rk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rk.bo.StudentBO;

@Repository("studDao")
public class StudentDAOImpl implements StudentDAO {

	//sql
	private static final String Select_Query="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SNO=?";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public StudentBO getStudentByNo(int sno) {
		
		StudentBO bo=null;
		
		//execute query
		bo=jt.queryForObject(Select_Query, //args 1 for sql query
															new BeanPropertyRowMapper<StudentBO>(StudentBO.class) ,    //internally working a hole method   [ arg2 for (Readymet method)]
															sno //arg 3 for param value set
															);
		
		return bo;
	}//method
	
}//outer class
