package com.rk.service;

import java.util.List;

import com.rk.dto.BankAccountDTO;

public interface IBankAccountMgmtService {

	public List<BankAccountDTO>  fetchBankAccountBySal(float start,float end);
	
}
