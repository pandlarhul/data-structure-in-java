package com.ds.queue;

import java.util.Scanner;

import com.ds.exception.QueueException;

public class UseQueue {
	public static void main(String[] args) {
		FixedArrayQueue queue = new FixedArrayQueue(3);
		Scanner scn = new Scanner(System.in);
		int choice = 0;
		int element = 0;

		while (true) {
			try {
				System.out.println("\n queue elements are = ");
				queue.show();
				System.out.println("Queue Operation");
				System.out.println("1. enqueue element");
				System.out.println("2. dequeue element");
				System.out.println("3. exit");
				choice = scn.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the element=");
					element = scn.nextInt();
					queue.enQueue(element);
					break;
				case 2:
					element = queue.deQueue();
					System.out.println("Deque element = " + element);
					break;
				default:
					break;
				}
			} catch (QueueException e) {
				System.out.println("Exception = "+e.getMessage());
				System.out.println("You Caused an error");
			}
		}

	}

}
