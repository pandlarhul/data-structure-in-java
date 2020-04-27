package com.ds.stack;

import com.ds.util.Utility;

public class InfixEvaluation {
	public static void main(String[] args) {
		String s1 = "1+2*3/2";
		int result = evaluate(s1);
		System.out.println(result);
	}
	public static int evaluate(String expr)	{
		LStack<Integer> operand = new LStack<Integer>();
		LStack<Character> operator = new LStack<Character>();
		int result = 0;
		
		int i = 0;
		char c ;
		try {
		while(i < expr.length()) {
			c = expr.charAt(i);
			if(Utility.isOperator(c)) {
				while(!operator.isEmpty() && Utility.precedence(operator.peek()) > Utility.precedence(c) ) {
					int op1 = operand.pop();
					int op2 = operand.pop();
					char op = operator.pop();
					result = Utility.calculate(op1, op2, op);
					operand.push(result);
				}
				operator.push(c);
			} else	{
					int op = c - '0'; 
					operand.push(op);
				}
			i++;
		}
		operand.show();
		operator.show();
		
		while(!operator.isEmpty()) {
			int op1 = operand.pop();
			int op2 = operand.pop();
			char op = operator.pop();
			result = Utility.calculate(op1, op2, op);
			operand.push(result);
		}
		System.out.println();
		} catch(Exception e)	{
			System.out.println(e.getMessage());
		}
		return result;	
	}
	

}
