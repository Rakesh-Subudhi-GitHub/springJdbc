package com.rk.test;

import java.util.List;

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
		List<StudentDTO> listDTO=null;
		
		//create ioc container
		ctx=new ClassPathXmlApplicationContext("com/rk/cfgs/applicationContext.xml");
		
		//get service class object
		service=ctx.getBean("studService",StudentMgmtServiceImpl.class);
		
		//invoke the method of service class
		try {
			dto=service.fetchStudentByno(1001);
			System.out.println(dto);
			System.out.println("--------------------------------------------------------------------");
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//invoke the method of service class
				try {
					listDTO=service.fetchStudentByCity("ctc","hyd");
					listDTO.forEach(listdto->{
						System.out.println(listdto);
					});
					
				}
				catch (DataAccessException dae) {
					dae.printStackTrace();
				}
				
				try {
					System.out.println("----------------------------------------------------------------------------------------------------");
					listDTO=service.fetchStudentByCity1("ctc","hyd");
					listDTO.forEach(listdto->{
						System.out.println(listdto);
					});
					
				}
				catch (DataAccessException dae) {
					dae.printStackTrace();
				}
				
		//close ctx
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
