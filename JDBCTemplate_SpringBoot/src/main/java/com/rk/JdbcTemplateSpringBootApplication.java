package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.rk.Service.EmployeService;
import com.rk.Service.EmployeServiceImpl;

@SpringBootApplication
public class JdbcTemplateSpringBootApplication {

	public static void main(String[] args) {
		
		//properties
		ApplicationContext ctx=null;
		EmployeService service=null;
		
		ctx=SpringApplication.run(JdbcTemplateSpringBootApplication.class, args);
	
		//get bean
		service=ctx.getBean("eService",EmployeServiceImpl.class);
		
		//invoke the method
		try {
			
			System.out.println("count is:: "+service.fetchEmployeCount());
			}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close the container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
