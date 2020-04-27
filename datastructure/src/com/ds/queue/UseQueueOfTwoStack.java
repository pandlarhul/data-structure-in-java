package com.ds.queue;

import com.ds.exception.QueueException;
import com.ds.exception.StackException;

public class UseQueueOfTwoStack {
	public static void main(String[] args) {
		try {
			start();
		} catch (StackException | QueueException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e);
		}
	}
	public static void start() throws StackException, QueueException {
		QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>();
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		
	}
}
