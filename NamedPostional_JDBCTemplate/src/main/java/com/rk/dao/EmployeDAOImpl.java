package com.rk.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rk.bo.EmployeBO;

@Repository("empDAO")
public class EmployeDAOImpl implements IEmployeDAO {

	//sql
	private static final String SelectEmpName="SELECT ENAME FROM EMP WHERE EMPNO=:no";
	private static final String SelectEmpDetails="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=:job";
	
	@Autowired
	private NamedParameterJdbcTemplate npjt;
	
	@Override
	public String getEmpDetailsByEmpno(int Empno) {
	
//		Map<String,Object> paramMap= new HashMap();
//		paramMap.put("no",Empno);        (OR)
		
		Map<String,Object> paramMap=Map.of("no",Empno);
		
		String details=npjt.queryForObject(SelectEmpName ,
																				paramMap ,
																						String.class);
		return details;
	}

	@Override
	public List<EmployeBO> getEmployeDetailsByDesg(String Desg) {
		
		//prepare MapSqlParameterSource obj having names,values of the named parameters
		MapSqlParameterSource msps= new MapSqlParameterSource();
		
		msps.addValue("job",Desg);
//		
//		List<EmployeBO> listBO=npjt.query(SelectEmpDetails ,
//																					msps ,
//																								rs->{
//																									List<EmployeBO> listBO1= new ArrayList();
//																									whille(rs.next())
//																									{
//																										EmployeBO bo=new EmployeBO();
//																										bo.setEmpno(rs.getInt(1));
//																										bo.setEname(rs.getString(2));
//																										bo.setJob(rs.getString(3));
//																										bo.setSal(rs.getFloat(4));
//																										
//																										listBO1.add(bo);
//																									}//while
//																									return listBO1;
//																								});
	//	return listBO;
		return null;
	}
 
}
