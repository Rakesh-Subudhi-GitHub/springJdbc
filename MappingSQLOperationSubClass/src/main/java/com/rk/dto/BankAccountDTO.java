package com.rk.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BankAccountDTO implements Serializable {

	//properties
	private int acno; 
	private String holdername;
	private String status;
	private float bal;
}
