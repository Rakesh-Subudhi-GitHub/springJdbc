package com.rk.cfgs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.rk.Dao")
@PropertySource("com/rk/commons/jdbc.properties")
public class PersistanceConfig {
	
	@Autowired
	private Environment env;
	
	public HikariDataSource createDs()
	{
		HikariDataSource hkDs=null;
		
		hkDs=new HikariDataSource();
		
		hkDs.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		hkDs.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
		hkDs.setUsername(env.getRequiredProperty("jdbc.user"));
		hkDs.setPassword(env.getRequiredProperty("jdbc.pwd"));
		hkDs.setMinimumIdle(Integer.parseInt(env.getRequiredProperty("jdbc.hcp.minidle")));
		hkDs.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("jdbc.hcp.maxpoolsize")));
	
		return hkDs;
	}

	//create JDBC template
	@Bean(name="jt")
	public JdbcTemplate createJT()
	{
		return new JdbcTemplate(createDs());
	}
}
