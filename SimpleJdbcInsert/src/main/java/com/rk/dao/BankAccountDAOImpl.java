package com.rk.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.rk.bo.BankAccountBO;

@Repository("bankDAO")
public class BankAccountDAOImpl implements IBankAccountDAO {

	@Autowired
	private SimpleJdbcInsert sji;
	
	@Override
	public int register(BankAccountBO bo) {
	
	/*	//prepared MAP object having col names and values
		Map<String, Object> map=Map.of("acno", bo.getAcno() ,    //key    value                            //java 9 fetcher
																		"aname", bo.getHoldername() ,	//key    value
																				"status",bo.getStatus() ,  //key    value
																						"bal", bo.getBal() );   //key    value  */

		//another way
		
		//prepared BeanPropertiesSqlParameterSource object having BO class obj
								//but one conditions column name should match with BO properties
		BeanPropertySqlParameterSource bpsp= new BeanPropertySqlParameterSource(bo);
		
		//set db table name
		sji.setTableName("ACCOUNT_BANK");
		
		//execute query in dynamically
		             //int count=sji.execute(map); //for 1st technique
		int count=sji.execute(bpsp);
		
		return count;
	
	}//method

}//class
