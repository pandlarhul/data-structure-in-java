package com.ds.exception;

@SuppressWarnings("serial")
public class TreeException extends Exception{
	private String exception[] = {"Tree is empty",
			"Element is not Found exception",
			"Inserting element must be equal in counting",
			"element are not same Exception"
	};
	private int errorCode;
	public TreeException(int code)	{
		errorCode = code;
	}
	public String toString()	{
		return exception[errorCode];
	}

}
