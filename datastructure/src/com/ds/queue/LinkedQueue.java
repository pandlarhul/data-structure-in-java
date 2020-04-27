package com.ds.queue;

import com.ds.exception.QueueException;

public class LinkedQueue<T> {
	class Node {
		T data;
		Node next;
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node front;
	private Node rear;
	private int size ;

	public LinkedQueue() {
		front = null;
		rear = null;
		size = 0;
	}
	
	public void enQueue(T enQueueData)	{
		
		size ++;
		Node newData = new Node(enQueueData);
		if(front == null || rear == null) {
			front = rear = newData;
		} else {
			rear.next = newData;
			rear = newData; 
		}
	}
	
	public T deQueue() throws QueueException	{
		
		T deQueueData;
		if(front == null || rear == null) {
			throw new QueueException(1);
		} else {
			size --;
			deQueueData = front.data;
			front = front.next;
		}
		return deQueueData;
	}
	
	public void show() {
		Node ptr = front;
		while(ptr != null)	{
			System.out.println(" "+ptr.data);
			ptr = ptr.next;
		}	
	}
	
	public boolean isEmpty()	{
		return ((front == null));
	}
	
	public int size() {
		return size;
	}
	

}
