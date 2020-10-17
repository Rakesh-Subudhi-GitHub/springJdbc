package com.rk.dao;

public interface EmployeDAO {

	public int insertQuery(String name,String desg,float sal);
	public int addBonus(String desg,float bonus);
}
