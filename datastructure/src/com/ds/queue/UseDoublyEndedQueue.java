package com.ds.queue;

import com.ds.exception.DEQException;
import com.ds.exception.QueueException;

public class UseDoublyEndedQueue {
	public static void main(String[] args) {
		DoublyEndedQueue<Integer> deq = new DoublyEndedQueue<Integer>();
		deq.enQueueFront(10);
		deq.enQueueFront(20);
		deq.enQueueFront(30);
		System.out.println("After Enqueue in front =");
		deq.show();
		try {
			System.out.println("dequeue from front = "+deq.deQueueFront());
			deq.show();
			System.out.println("dequeue from rear = "+deq.deQueueRear());
			deq.show();
			System.out.println("dequeue from rear = "+deq.deQueueRear());
			deq.show();
			deq.enQueueRear(40);
			deq.show();
			System.out.println("dequeue from front = "+deq.deQueueFront());
		} catch (QueueException | DEQException e) {
			e.printStackTrace();
		}
	}

}
