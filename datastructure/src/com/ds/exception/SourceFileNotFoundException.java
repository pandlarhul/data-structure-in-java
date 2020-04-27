package com.ds.exception;

public class SourceFileNotFoundException extends Exception {
	private String msg = "";
	public SourceFileNotFoundException(String msg) {
		this.msg = msg;
	}
	public String toString()	{
		return msg;
	}

}
