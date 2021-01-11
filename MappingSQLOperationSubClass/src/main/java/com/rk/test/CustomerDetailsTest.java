package com.rk.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.rk.dto.BankAccountDTO;
import com.rk.service.BankAccountMgmtServiceImpl;
import com.rk.service.IBankAccountMgmtService;

public class CustomerDetailsTest {

	public static void main(String[] args) {
		
		//properties
		ApplicationContext ctx=null;
		IBankAccountMgmtService service=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		
		//get service class object
		service=ctx.getBean("bankService",BankAccountMgmtServiceImpl.class);
		
		//invoke the service method
		try {
			
		List<BankAccountDTO> listDTO=null;
		
		listDTO=service.fetchBankAccountBySal(1000,2000);
		
		listDTO.forEach(dto->{
			System.out.println("anskja");
									System.out.println(dto);
								});
		
		}//try
		
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close ctx
		((AbstractApplicationContext) ctx).close();
		
	}//main
}//class
