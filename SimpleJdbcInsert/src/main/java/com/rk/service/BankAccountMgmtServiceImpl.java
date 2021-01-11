package com.rk.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rk.bo.BankAccountBO;
import com.rk.dao.IBankAccountDAO;
import com.rk.dto.BankAccountDTO;

@Repository("bankService")
public class BankAccountMgmtServiceImpl implements IBankAccountMgmtService {
	
	@Autowired
	private IBankAccountDAO dao;

	@Override
	public String openAccount(BankAccountDTO dto) {
		
		//value send  dto --> bo
		BankAccountBO bo=null;
		bo=new BankAccountBO();
		
		BeanUtils.copyProperties(dto, bo);
		
		//use DAO
		int count=dao.register(bo);
		
		if(count==0)
			return "BankAccount is not opened";
		else
		return "BankAccount is opened";
	}

}
