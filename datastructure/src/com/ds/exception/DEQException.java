package com.ds.exception;

public class DEQException extends Exception{
		private static String message[] = {"Doubly Ended Queue OverFlow Exception",
								" Doubly Ended Queue UnderFlow Exception"};
		private int messageCode;
		public DEQException(int messageCode)	{
			super(message[messageCode]);
			this.messageCode = messageCode;
		}
		public String toString()	{
			return message[messageCode];
		}
		


}
