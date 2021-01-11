package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.rk.dto.StudentDTO;
import com.rk.service.StudentMgmtService;
import com.rk.service.StudentMgmtServiceImpl;

@SpringBootApplication
public class JdbcTemplateRowmapperApplication {

	public static void main(String[] args) {
		
		//properties
		ApplicationContext ctx=null;
		StudentMgmtService service =null;
		StudentDTO dto=null;
		
		//create IOC container
		ctx=SpringApplication.run(JdbcTemplateRowmapperApplication.class, args);
		
		//get service class object
				service=ctx.getBean("studService",StudentMgmtServiceImpl.class);
				
				//invoke the method of service class
				try {
					dto=service.fetchStudentByno(1001);
					System.out.println(dto);
					
				}
				catch (DataAccessException dae) {
					dae.printStackTrace();
				}
				
				//close ctx
				((AbstractApplicationContext) ctx).close();
		
	}//main

}//class
