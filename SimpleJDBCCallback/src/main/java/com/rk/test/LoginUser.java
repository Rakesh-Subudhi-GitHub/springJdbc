package com.rk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rk.service.AuthenticationServiceImpl;
import com.rk.service.IAuthenticationService;

import oracle.net.ano.AuthenticationService;

public class LoginUser {

	public static void main(String[] args) {
		
	//properties
	ApplicationContext ctx=null;
	IAuthenticationService service=null;
	
	//create IOC container
	ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
	
	//getService class object
	service=ctx.getBean("aService",AuthenticationServiceImpl.class);

	//invoke the Service method
	String result=service.login("rakesh", "ritu");
	System.out.println(result);
	
	//close ctx
	((AbstractApplicationContext) ctx).close();
	
	}//main
}//class