package com.rk.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.Service.EmployeService;
import com.rk.Service.EmployeServiceImpl;

public class JDBCTemplateTest {

	public static void main(String[] args) {
		
		//properties
		ApplicationContext ctx=null;
		EmployeService service=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		
		//getBeans
		service=ctx.getBean("eService",EmployeServiceImpl.class);
		
		//invoke the method of Service class
		try {
			System.out.println("emp count is ::  "+service.fetchEmployeCount());
		}
		
		catch (Exception e) {
		e.printStackTrace();
		}
		
		//close ctx
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
