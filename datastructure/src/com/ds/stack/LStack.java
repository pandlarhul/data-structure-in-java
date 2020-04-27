package com.ds.stack;

import com.ds.exception.StackException;

public class LStack<T> {
	private Node top;
	private int size;

	class Node {
		T data;
		Node next;

		public Node(T data) {
			this.data = data;
		}
	}

	public LStack() {
		top = null;
		size = 0;
	}

	public void push(T data) {
		Node newData = new Node(data);
		size ++;
		if (top == null) {
			top = newData;
		} else {
			newData.next = top;
			top = newData;
		}
	}
	
	public T pop()	throws StackException{
		T popElement;
		if(top == null) {
			throw new StackException(2);
		} else {
				size --;
				popElement = top.data;
				top = top.next;
			}
		return popElement;
	}
	
	public T peek()	{
		return top.data;
	}
	
	public int size()	{
		return size;
	}
	
	public boolean isEmpty()	{
		return top==null;
	}
	public  void show()	{
		@SuppressWarnings("rawtypes")
		LStack.Node ptr = top;
		while(ptr != null)	{
			System.out.print(" "+ptr.data);
			ptr = ptr.next;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LStack<T> reverse()	{
		
		LStack<T> temp = new LStack<T>();
		LStack.Node ptr = top;
		while(ptr != null)	{
			temp.push((T) ptr.data);
			ptr = ptr.next;
		}
		return temp;
	}
	
	@SuppressWarnings("rawtypes")
	public  void showWithAddress()	{
		LStack.Node ptr = top;
		while(ptr != null)	{
			System.out.println(ptr+" "+ptr.data);
			
			ptr = ptr.next;
		}
	}

	
}
