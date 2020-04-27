package com.ds.stack;

import com.ds.exception.StackException;

public class PostfixEvaluation {
	public static void main(String[] args) {
		String expr = "123*+5-";
		try {
			System.out.println(postfixResult(expr));
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int postfixResult(String expr) throws StackException {

		// stack is initialized
		LStack<Character> evaluationStack = new LStack<Character>();

		// initialized character
		char c;

		try {
			for (int i = 0; i < expr.length(); i++) {
				c = expr.charAt(i);
				if (c >= '0' && c <= '9') {
					evaluationStack.push(c);
				} else if (InfixToPostfix.isOperator(c)) {
					char operand1 = evaluationStack.pop();
					char operand2 = evaluationStack.pop();
					char result = calculate(operand1, operand2, c);
					evaluationStack.push(result);
				}
			}
		} catch (StackException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return evaluationStack.pop() - '0';

	}

	private static char calculate(char operand1, char operand2, char c) {
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

}
