package com.rk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.rk.dto.BankAccountDTO;
import com.rk.service.BankAccountMgmtServiceImpl;
import com.rk.service.IBankAccountMgmtService;

public class BankAccountTest {

	public static void main(String[] args) {
		
		//properties
		ApplicationContext ctx=null;
		IBankAccountMgmtService service=null;
		
		BankAccountDTO dto=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		
		//use service object
		service=ctx.getBean("bankService",BankAccountMgmtServiceImpl.class);
		
		try {
			dto=new BankAccountDTO();
			
			//convert set dto values
			dto.setAcno(1001);
			dto.setHoldername("raja");
			dto.setStatus("activate");
			dto.setBal(9904.54f);
			
			//invoke the service method
			String result=service.openAccount(dto);
			System.out.println(result);
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close ctx
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
