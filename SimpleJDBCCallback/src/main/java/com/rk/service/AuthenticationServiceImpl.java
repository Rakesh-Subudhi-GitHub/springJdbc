package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.dao.IAuthenticationDAO;

@Service("aService")
public class AuthenticationServiceImpl implements IAuthenticationService {

	@Autowired
	private IAuthenticationDAO dao;
	
	@Override
	public String login(String user, String pwd) {
		
		//use dao
		String result=dao.authentication(user, pwd);
		
		return result;
	}//method

}//class
