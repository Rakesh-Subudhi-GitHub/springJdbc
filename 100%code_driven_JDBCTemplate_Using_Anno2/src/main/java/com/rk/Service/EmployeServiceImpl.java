package com.rk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.Dao.EmployeDao;

@Service("eService")
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeDao edao;
	
	@Override
	public int fetchEmployeCount() {
		
		//calling EmployeDao method and return value
		return edao.getEmployeCount();
	}//method

}//class
