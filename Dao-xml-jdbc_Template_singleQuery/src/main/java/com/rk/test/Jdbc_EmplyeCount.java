package com.rk.test;

import org.springframework.dao.DataAccessException;

import com.rk.service.EmployeMgmtService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Jdbc_EmplyeCount {

	public static void main(String[] args) {
		
		//read inputs
		
		ApplicationContext ctx=null;
		EmployeMgmtService service=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationcontext.xml");
		
		//get SErvice class object
		service=ctx.getBean("empService",EmployeMgmtService.class);
		
		//invoke the b.method
		try {
			System.out.println("emps count::"+service.fetchEmployeCount());
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("7499 record emp name is ::"+service.fetchEmployeName(7499));
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class