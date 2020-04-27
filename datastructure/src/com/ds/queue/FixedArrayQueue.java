package com.ds.queue;

import com.ds.exception.QueueException;

public class FixedArrayQueue {
	private int queue[];
	private int capacity;
	private int size;
	private int front;
	private int rear;
	public FixedArrayQueue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		front = -1;
		rear = -1;
	}
	
	public void enQueue(int data) throws QueueException	{
		
		if(isFullQueue()) {
			throw new QueueException(0);
		} else {
			//System.out.println(data);
			
			if(rear== -1 &&  front == -1) {
				rear=front=0;
			} else {
				rear = (rear+1)%capacity;
			}
			queue[rear] = data;
		}
		size();
		//System.out.println("front="+front+" rear="+rear);
		//completeArray();
		//System.out.println("front="+front+" rear="+rear);
	}
	
	public int deQueue() throws QueueException	{
		int data;
		if(isEmptyQueue()) {
			throw new QueueException(1);
		} else {
			data = queue[front];
			queue[front] = 0;
			if(front == rear) {
				front = -1;
				rear = -1;
			} else {
				front += 1;
			}
			front %= capacity;
		}
		size();
		return data;
	}
	
	
	
	public boolean isEmptyQueue() {
		return front == -1;
	}

	public boolean isFullQueue()	{
		return (rear+1)%capacity == front;
	}
	
	
	public void show()	{
		//size = size();
//		System.out.println("ss="+size);
//		System.out.println("front="+front+" rear="+rear);
//		//System.out.println("front="+front+" rear="+rear);
		int i = 0;
		if(front ==-1 &&  rear ==-1) {
			System.out.println("Empty Queue");
			return;
		}
		int index = front;
		while( i++ < size) {
				System.out.print(" "+queue[index++]);
				index %= capacity;
		}
		System.out.println();
	}
	
	public int size()	{
		size = Math.abs((capacity+rear-front)%capacity + 1);
		return Math.abs(size);
	}
	
	private void completeArray() {
		System.out.println("start");
		for (int i = 0; i < queue.length; i++) {
			System.out.print(" "+queue[i]);
		}
		System.out.println("end");
	}

}
