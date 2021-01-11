package com.rk.bo;

import lombok.Data;

@Data
public class BankAccountBO {

	//properties
	private int acno; 
	private String holdername;
	private String status;
	private float bal;
}
