package com.ds.stack;

public class PalindromeUsingStack {
	public static void main(String[] args) {
		String s1 = "ababaXababaa";
		LStack<Character> reverseStack = new LStack<Character>();
		int i = 0;
		while(i < s1.length())	{
			reverseStack.push(s1.charAt(i++));
		}
		
		i = 0;
		try {
		while(reverseStack.isEmpty())	{
			if(reverseStack.pop() == s1.charAt(i++)) {
				continue;
			} else break; 
		}
		
			if(reverseStack.isEmpty()) {
				System.out.println("User :Am i Palindrome?");
				System.out.println("System: Yes");
			} else {
				System.out.println("User :Am i Palindrome?");
				System.out.println("System: No");
			}
		} catch(Exception e)	{
			System.out.println(e.getMessage());
		}
	}

}
