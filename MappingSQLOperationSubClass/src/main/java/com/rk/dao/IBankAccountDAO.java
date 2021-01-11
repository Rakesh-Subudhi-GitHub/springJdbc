package com.rk.dao;

import java.util.List;

import com.rk.bo.BankAccountBO;

public interface IBankAccountDAO {

	public List<BankAccountBO> getBankAccountDetailsByBalanceRange(float start,float end);
}
