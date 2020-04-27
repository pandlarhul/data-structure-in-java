package com.ds.stack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ds.exception.SourceFileNotFoundException;

public class BalanceSymbol {
	/**
	 * @param args
	 */
	
	public static void main(String args[])	{
		String s1 = "{(([])[])[]]}";
		System.out.println(isBalanced(s1));
//		Pattern pattern = Pattern.compile(".");
//		Matcher match = pattern.matcher(s1);
//		File newFile = new File("C:\\Users\\lenovo\\eclipse-workspace\\datastructure\\src\\com\\ds\\stack\\Stack.java");
//		while(match.find())	{
				
		
		
		
	}
	public static boolean isBalanced(File sourceFile) throws SourceFileNotFoundException {
		if(sourceFile.exists()) {
			throw new SourceFileNotFoundException("Source File not Found Exception");
		}
		boolean isBalanced = false;
		Scanner scn = new Scanner(System.in);
		//
//		if(sourceFile)
		int c = 0;
		String expr = "";
		try {
			FileInputStream fis = new FileInputStream(sourceFile);
			while ((c = fis.read()) != -1) {
				expr += (char)c;
			}
			fis.close();
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String expression = expr;
		if (isBalanced(expression)) {
			isBalanced = true;
		} else {
			isBalanced = false;
		}
		return isBalanced;
	}
	
	

	public static boolean isBalanced(String expression) {
		boolean isBalanced = false;
		String opening = "";
		String closing = "";
		String s1 = expression;
		LStack<Character> symbolStack = new LStack<Character>();

		char c;
		int i = 0;
		try {

			for (i = 0; i < s1.length(); i++) {
				c = s1.charAt(i);
				if (isOpenParenthesis(c)) {
					opening += c;
					symbolStack.push(c);
				} else if (c == '}' || c == ']' || c == ')') {
					closing += c;
					char peekChar = symbolStack.peek();
					//System.out.println("peek char ="+peekChar);
					if (symbolStack.isEmpty()) {
						break;
					} else if (isMatching(c, peekChar)) {
						symbolStack.pop();
					}
				}
			}
//			System.out.println("cover length="+s1.length());
//			System.out.println(symbolStack.isEmpty());
//			System.out.println("cover length="+i);
			if (symbolStack.isEmpty() && i == s1.length()) {
				isBalanced = true;
			} else {
				isBalanced = false;
			}
//			System.out.println();
//			System.out.println("opening="+opening);
//			System.out.println("opening length="+opening.length());
//			System.out.println("closing="+closing);
//			System.out.println("closing length="+closing.length());
		} catch (Exception e) {
			System.out.println("Exception is =" + e.getMessage());
		}
		return isBalanced;
	}

	public static boolean isOpenParenthesis(char c) {
		if (c == '{' || c == '[' || c == '(') {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isMatching(char c, char peek) {

		if ((c == '}' && peek == '{') || (c == ']' && peek == '[') || (c == ')' && peek == '(')) {
			return true;
		} else {
			return false;
		}
	}

}
