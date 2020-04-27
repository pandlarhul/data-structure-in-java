package com.ds.stack;

public class PalindromeUsingArray {
	public static void main(String[] args) {
		String s1 = "ababaXababaa";
		int start = 0;
		int end  = s1.length()-1;
		char c = '0';
		while( s1.charAt(start) != 'X')	{
			if(s1.charAt(start) == s1.charAt(end)) {
				start ++ ;
				end -- ;
			} else {
				break;
			}
		}
		
		if(s1.charAt(start) == 'X' && s1.charAt(end)=='X') {
			System.out.println("Palindrome");
		} else {
			System.out.println("Palindrome not");
		}
	}

}
