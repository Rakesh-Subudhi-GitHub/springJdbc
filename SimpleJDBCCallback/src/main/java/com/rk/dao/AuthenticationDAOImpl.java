package com.rk.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("authDao")
public class AuthenticationDAOImpl implements IAuthenticationDAO{

	@Autowired
	private SimpleJdbcCall sjc;
	
	@Override
	public String authentication(String user, String pwd) {
		
		//set procedure name
		sjc.setProcedureName("P_AUTHENTICATION");
		
		//prepare Map in param
		Map<String,?> inparam=Map.of("USERNAME", user,"PASSWORD",pwd);
		
		//execute PL/SQL procedure
		Map<String,?> outparam=sjc.execute(inparam);
		
		return (String) outparam.get("RESULT");
	
	}//method

}//class
