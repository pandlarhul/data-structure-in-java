package com.ds.exception;


@SuppressWarnings("serial")
public class QueueException extends Exception{
	private static String message[] = {"Queue OverFlow Exception",
							"Queue UnderFlow Exception"};
	private int messageCode;
	public QueueException(int messageCode)	{
		super(message[messageCode]);
		this.messageCode = messageCode;
	}
	public String toString()	{
		return message[messageCode];
	}
	
}
