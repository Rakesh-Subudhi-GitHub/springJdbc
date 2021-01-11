package com.rk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.service.EmployeServiceImpl;
import com.rk.service.IEmployeService;

public class EmployeDetailsTest {

	public static void main(String[] args) {
		
		//properties
		ApplicationContext ctx=null;
		IEmployeService service=null;
		
		//create IOC container
		ctx= new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		
		//get service class obj
		service=ctx.getBean("empService", EmployeServiceImpl.class);
		
		//invoke the method
		String detail=null;
		detail=service.featchEmployeDetailsByEmpno(7499);
		System.out.println("7499 emp name is : "+detail);
	
		//close ctx
		((AbstractApplicationContext) ctx).close();

	}//main
	
}//class
