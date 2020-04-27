package com.ds.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.ds.exception.StackException;

public class InfixToPostfix {

	public static void main(String[] args) {
		LStack<Character> stack = new LStack<Character>();

		String expr = "a*b-(c+d)+e";
		String postfix = "";
		try {
			for (int i = 0; i < expr.length(); i++) {
				char c = expr.charAt(i);
				if (isOperand(c)) {
					System.out.println("isoperand=" + c);
					postfix += c;
				} else if (isRightParenthesis(c)) {
					System.out.println("is right parenthis" + c);
					char temp = stack.peek();
					while (!isLeftParenthesis(temp)) {
						postfix += stack.pop();
						temp = stack.peek();
					}
					stack.pop();
				} else if (isOperator(c) || isLeftParenthesis(c) || stack.isEmpty()) {
					System.out.println("isoperator = " + c);
					while (true) {
						if (stack.isEmpty())
							break;
						else if (precedence(c) >= precedence(stack.peek()))
							break;
						else if (isLeftParenthesis(stack.peek())) {
							break;
						} else {
							postfix += stack.pop();
						}
					}
					stack.push(c);
				}
			}
			//stack.show();
			while(!stack.isEmpty() )	{
				postfix += stack.pop();
			}
			System.out.println(postfix);
		} catch (StackException e) {
			e.printStackTrace();
		}
	}

	public static int precedence(char c) {
		HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
		char operator[] = { '(', ')', '*', '/', '%', '+', '-' };
		int value[] = { 19, 19, 18, 18, 18, 17, 17 };

		for (int i = 0; i < operator.length; i++)
			priority.put(operator[i], value[i]);
		return priority.get(c);
	}

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
		return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
	}

}