package com.ds.queue;

import com.ds.exception.QueueException;
import com.ds.exception.StackException;
import com.ds.stack.LStack;

public class ReverseFirstKElement {
	public static void main(String[] args) {
		int a[] = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		int k = 4;
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		for (int i = 0; i < a.length; i++) {
			queue.enQueue(a[i]);
		}
		
		
		try {
			queue = reverseFirstKElement(queue, k);
			System.out.println("After Reversing "+k+" element=");
			queue.show();
		} catch (Exception e) {

		}

	}

	public static <T> LinkedQueue<T> reverseFirstKElement(LinkedQueue<T> queue, int k)
			throws QueueException, StackException {
		LStack<T> KElement = new LStack<T>();
		LinkedQueue<T> reverseQueue = new LinkedQueue<T>();

		int i = 0;
		for (; i < k; i++) {
			KElement.push(queue.deQueue());
		}

		while (!KElement.isEmpty()) {
			reverseQueue.enQueue(KElement.pop());
		}

		while (!queue.isEmpty()) {
			reverseQueue.enQueue(queue.deQueue());
		}
		return reverseQueue;
	}

}
