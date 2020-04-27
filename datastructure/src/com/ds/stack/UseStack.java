package com.ds.stack;

import com.ds.exception.StackException;

public class UseStack {
	public static void main(String[] args) {
		LStack<Character> st = new LStack<Character>();
		try {
			st.push('}');
			System.out.println(st.peek());
			System.out.println(st.pop());
			System.out.println(st.pop());
			st.show();
			
		} catch (StackException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		
	}

}
