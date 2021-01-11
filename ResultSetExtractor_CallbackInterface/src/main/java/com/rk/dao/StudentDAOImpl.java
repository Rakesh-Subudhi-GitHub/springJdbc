package com.rk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rk.bo.StudentBO;

@Repository("studDAO")
public class StudentDAOImpl implements StudentDAO {

	//sql
	private static final String Select_Query="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SNO=?";
	private static final String Select_Query_By_City="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SADD IN(?,?)";
	
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

	@Override
	public List<StudentBO> getStudentByCity(String city1, String city2) {
		
		//properties
		List<StudentBO> listBO=null;
		
		listBO=jt.query(Select_Query_By_City,
												new StudentExtractor() ,
														city1,city2 );
		
		return listBO;
		
	}//Method
	
	//inner class
	public class StudentExtractor implements ResultSetExtractor<List<StudentBO>>{

		@Override
		public List<StudentBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			
			//properties
			List<StudentBO> listBO=null;
			StudentBO BO=null;
			
			//copy RS object record to list of StudentBO collection
			listBO=new ArrayList();
			
			while(rs.next())
			{
				//get each record into StudentBO 
				BO=new StudentBO();
				
				BO.setSno(rs.getInt(1));
				BO.setSname(rs.getString(2));
				BO.setSadd(rs.getString(3));
				BO.setAvg(rs.getFloat(4));
				
				//add listBO
				listBO.add(BO);
			
			}//while
			
			//return listBO	
			return listBO;
		
		}//inner class
		
	}
}//outer class
