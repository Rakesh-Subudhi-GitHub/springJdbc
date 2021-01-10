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
			System.out.println("--------------------------------------------------------------------------------");
		}
		
		catch (Exception e) {
		e.printStackTrace();
		}
		
				//invoke the method of Service class
				try {
					System.out.println("7499 emp name is ::  "+service.fetchEmployeName(7499));
					System.out.println("--------------------------------------------------------------------------------");
				}
				
				catch (Exception e) {
				e.printStackTrace();
				}
				
						//invoke the method of Service class
						try {
								System.out.println("7499 emp Full details is ::  "+service.fetchEmpDetails(7499));
								System.out.println("---------------------------------------------------------------------------");
							}
				
						catch (Exception e) {
							e.printStackTrace();
							}
			
						//invoke the method of Service class
						try {
							//System.out.println("EMPLOYE DETAILS IN JOB ::  "+service.fetchEmpDetailsByDesg("MANAGER","CLERK"));
						
							service.fetchEmpDetailsByDesg("MANAGER","CLERK").forEach(map->{
										System.out.println(map);
											});
						}
						
						catch (Exception e) {
						e.printStackTrace();
						}
						
						//invoke the method of Service class
						try {
								System.out.println("---------------------------------------------------------------------------");
								int count=service.fetchInsertEmp(100,"rakesh","engg", 7878.85f);
						
								if(count==1)
									System.out.println("Employe insert succesfully");
								else
									System.out.println("employe not inserted");
						}
				
						catch (Exception e) {
							e.printStackTrace();
							}
					
						//invoke the method of Service class
						try {
								System.out.println("---------------------------------------------------------------------------");
								int count=service.fetchAddBonus(7499,500);
						
								if(count==1)
									System.out.println("Employe salary is updated");
								else
									System.out.println("employe not updated");
						}
				
						catch (Exception e) {
							e.printStackTrace();
							}
		//close ctx
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
