package com.ds.queue;

import com.ds.exception.DEQException;
import com.ds.exception.QueueException;
import com.ds.queue.LinkedQueue.Node;

public class DoublyEndedQueue<T> {

	class Node {
		T data;
		Node next;
		Node pre;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.pre = null;
		}
	}

	private Node front;
	private Node rear;
	private int size;

	public DoublyEndedQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	public void enQueueRear(T enQueueData) {

		size++;
		Node newData = new Node(enQueueData);
		if (front == null || rear == null) {
			front = rear = newData;
		} else {
			rear.next = newData;
			newData.pre = rear;
			rear = newData;
		}
	}

	public T deQueueFront() throws QueueException, DEQException {

		T deQueueData;
		if (front == null || rear == null) {
			throw new DEQException(1);// 1 code for overflow
		} else {
			size--;
			deQueueData = front.data;
			front = front.next;
			if(front != null)
			front.pre = null;
			else 
				front=rear=null;
		}
		return deQueueData;
	}

	public void enQueueFront(T enQueueData) {

		size++;
		Node newData = new Node(enQueueData);
		if (front == null || rear == null) {
			front = rear = newData;
		} else {
			newData.next = front;
			front.pre = newData;
			front = newData;
		}
	}

	public T deQueueRear() throws QueueException, DEQException {
		T deQueueData;
		if (front == null || rear == null) {
			throw new DEQException(1);// 1 code for overflow
		} else {
			size--;
			deQueueData = rear.data;
			//System.out.println("rear.next="+rear.data);
				rear = rear.pre;
				if(rear != null)
				rear.next = null;
				else
				{
					front = null;
					rear = null;
				}
				
		}
		return deQueueData;
	}

	public void show() {
		Node ptr = front;
		while (ptr != null) {
			System.out.println(" " + ptr.data);
			ptr = ptr.next;
		}
	}

	public boolean isEmpty() {
		return ((front == null));
	}

	public int size() {
		return size;
	}

}
