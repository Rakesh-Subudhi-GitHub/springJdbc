package com.rk.service;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.rk.bo.BankAccountBO;
import com.rk.dao.IBankAccountDAO;
import com.rk.dto.BankAccountDTO;

@Service("bankService")
public class BankAccountMgmtServiceImpl implements IBankAccountMgmtService{

	@Autowired
	private IBankAccountDAO dao;
	
	@Override
	public List<BankAccountDTO> fetchBankAccountBySal(float start, float end) {
		
		//use DAO
		List<BankAccountBO> listbo=dao.getBankAccountDetailsByBalanceRange(start, end);
		
		//convert bo to dto
				//dto<--bo
		List<BankAccountDTO> listdto=new ArrayList();
		
		listbo.forEach(bo->{
			BankAccountDTO dto=new BankAccountDTO();
			BeanUtils.copyProperties(listbo, listdto);
			
			listdto.add(dto);
		});
		
		return listdto;
		
	}//method

}//class
