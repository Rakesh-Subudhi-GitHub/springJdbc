package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.rk.bean.Persion;

@SpringBootApplication
public class BootPropertiesValueConfigurationApplication {

	public static void main(String[] args) {
		
		//properties
		ApplicationContext ctx=null;
		Persion perion=null;
		
		ctx=SpringApplication.run(BootPropertiesValueConfigurationApplication.class, args);
	
		//get bean in Bean class
		perion=ctx.getBean("persionBean",Persion.class);
		
		//result
		System.out.println(perion);
		
		//close ctx
		((ConfigurableApplicationContext) ctx).close();
		
	}//main

}//class
