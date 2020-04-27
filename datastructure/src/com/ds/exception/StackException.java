package com.ds.exception;

@SuppressWarnings("serial")
public class StackException extends Exception{
	// call from Stack ADT
	private static String error[] = {"Stack Overflow Exception",
						"Stack Under flow Exception",
						"Null Pointer Exception"
						};
	int msgCode;
	public StackException(int msg)	{
		super(error[msg]);
		this.msgCode = msg;
	}
	
	public String toString()	{
		
		return error[msgCode];
	}
	
	

}
