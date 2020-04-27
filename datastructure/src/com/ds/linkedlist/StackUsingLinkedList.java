package com.ds.linkedlist;

public class StackUsingLinkedList {
	public static void main(String[] args) {
		LinkedList<String> stack = new LinkedList<String>();
		stack.push("first");
		stack.push("second");
		stack.push("third");
		stack.push("forth");
		
		System.out.println(stack.size());
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
		
		
		
	}

}
