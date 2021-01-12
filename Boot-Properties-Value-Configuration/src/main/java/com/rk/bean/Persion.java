package com.rk.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("persionBean") //just Bean class so Service class @service just like that only
@ConfigurationProperties(prefix = "per.info")
public class Persion {

	//simple properties
	private int id;
	private String name;
	private String addrs;
	
	//arrays
	private int[] mark1;
	
	//list
	private List<Integer> mark2;
	
	//set
	private Set<Integer> mark3;
	
	//Map
	private Map<String,Long> phone;
	
	//another class beans
	private Job job; //Has-A RelationShip properties
	
}//class
