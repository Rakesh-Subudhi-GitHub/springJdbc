package com.rk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import com.rk.bo.BankAccountBO;

@Repository("bankDao")
public class BankAccountDAOImpl implements IBankAccountDAO {

	//sql
	private static final String GetDetailsByBalance="SELECT ACNO,HOLDERNAME,BAL,STATUS FROM ACCOUNT_BANK WHERE BAL>=? AND BAL<=?";
	//SELECT ACNO,HOLDERNAME,BAL,STATUS FROM ACCOUNT_BANK WHERE BAL>=1000 AND BAL<=5000;
	
	BankAccountSelectByRange select1;
	
	@Autowired
	private DataSource ds;
	
	public BankAccountDAOImpl(DataSource ds) {
		System.out.println("0-param constructor calling");
		select1=new BankAccountSelectByRange(ds, GetDetailsByBalance);
	}
	
	@Override
	public List<BankAccountBO> getBankAccountDetailsByBalanceRange(float start, float end) {
	
		List<BankAccountBO> listbo=select1.execute(start,end);
		
		return listbo;
		
	}//method

	//inner class
	private static class BankAccountSelectByRange extends MappingSqlQuery<BankAccountBO>{

		public BankAccountSelectByRange(DataSource ds,String query) {
			
			//gives DS,query to super class
			super(ds,query);
			
			//register query param
			super.declareParameter(new SqlParameter(Type.FLOAT));
			super.declareParameter(new SqlParameter(Type.FLOAT));
			
			//makes super class compile query
			super.compile();
		}//constructor
		
		@Override
		protected BankAccountBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			BankAccountBO bo=null;
			
			//convert RS to BO class object
			// BO<--RS
			bo=new BankAccountBO();
			
			bo.setAcno(rs.getInt(1));
			bo.setHoldername(rs.getString(2));
			bo.setBal(rs.getFloat(3));
			bo.setHoldername(rs.getString(4));
			
			return bo;
		}
		
	}//inner class
}//outer class
