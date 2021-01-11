package com.rk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.rk.dto.StudentDTO;
import com.rk.service.StudentMgmtService;
import com.rk.service.StudentMgmtServiceImpl;

public class StudentTest {

	public static void main(String[] args) {
		
		//properties
		ApplicationContext ctx=null;
		StudentMgmtService service=null;
		StudentDTO dto=null;
		
		//create ioc container
		ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		
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
