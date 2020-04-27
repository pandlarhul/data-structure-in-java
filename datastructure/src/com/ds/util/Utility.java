package com.ds.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Utility {

	/*
	 * This method will generate result in char form  of operand operator operand
	 * @param  char operand,char operand,char operator
	 * @return type evaluate expression in char form
	 * 
	 */
	@SuppressWarnings("unused")
	public static char calculate(char operand1, char operand2, char c) {
		int value1 = operand2 - '0';
		int value2 = operand1 - '0';
		int result = 0;
		switch (c) {
		case '+':
			result = value1 + value2;
			break;
		case '-':
			result = value1 - value2;
			break;
		case '*':
			result = value1 * value2;
			break;
		case '/':
			result = value1 / value2;
			break;
		}
		return (char) (result + '0');
	}

	
	/*
	 * This method will generate result in int form  of operand operator operand
	 * @param  int operand,int operand,char operator
	 * @return type evaluate expression in int form
	 * 
	 */
	@SuppressWarnings("unused")
	public static int calculate(int operand1, int operand2, char c) {
		int value1 = operand2 ;
		int value2 = operand1 ;
		int result = 0;
		switch (c) {
		case '+':
			result = value1 + value2;
			break;
		case '-':
			result = value1 - value2;
			break;
		case '*':
			result = value1 * value2;
			break;
		case '/':
			result = value1 / value2;
			break;
		}
		return  result;
	}

	
	
	/*
	 * This method will give the precedence of basic  operator
	 * @param  		char operator
	 * @return 		Integer value
	 * 
	 */	
	public static int precedence(char c) {
		HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
		char operator[] = { '(', ')', '*', '/', '%', '+', '-' };
		int value[] = { 19, 19, 18, 17, 17, 16, 16 };

		for (int i = 0; i < operator.length; i++)
			priority.put(operator[i], value[i]);
		return priority.get(c);
	}
	
	
	/*
	 * This method will check the passing character is left paranthesis or not
	 * @param  		char 
	 * @return 		boolean
	 * 
	 */
	public static boolean isLeftParenthesis(char c) {
		return c == '(';
	}

	
	public static boolean isRightParenthesis(char c) {
		return c == ')';
	}

	
	public static boolean isOperator(char c) {
		char op[] = { '+', '-', '*', '/', '%' };
		List<Character> operator = new LinkedList<Character>();
		for (int i = 0; i < op.length; i++) {
			operator.add(op[i]);
		}
		return operator.contains(c);
	}

	public static boolean isOperand(char c) {
		return ( (c >= '0' && c <= '9'));
	}



}
