package com.ds.queue;

import com.ds.exception.DEQException;
import com.ds.exception.QueueException;
import com.ds.exception.StackException;
import com.ds.stack.LStack;

public class AlternateMergeQueueElement {
	public static void main(String[] args) {
		int a[] = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		for (int i = 0; i < a.length; i++) {
			queue.enQueue(a[i]);
		}
		try {
			queue = mergeUsingDEQ(queue);
			System.out.println("after merge");
			queue.show();
		} catch (QueueException | DEQException | StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static <T> LinkedQueue<T> merge(LinkedQueue<T> queue) throws QueueException {
		LinkedQueue<T> firstHalf = new LinkedQueue<T>();
		LinkedQueue<T> secondHalf = new LinkedQueue<T>();
		LinkedQueue<T> mergeQueue = new LinkedQueue<T>();
		int i = 0;
		int size = queue.size();

		while (i < size / 2) {
			T data1 = (T) queue.deQueue();
			firstHalf.enQueue(data1);
			i++;
		}
		while (!queue.isEmpty()) {
			T data1 = queue.deQueue();
			secondHalf.enQueue(data1);
		}

//		data1 = firstHalf.deQueue();
//		data2 = secondHalf.deQueue();
//		System.out.println(data1+" "+data2);

		while (!(firstHalf.isEmpty()) && (!secondHalf.isEmpty())) {
			T data1 = firstHalf.deQueue();
			T data2 = secondHalf.deQueue();
			mergeQueue.enQueue(data1);
			mergeQueue.enQueue(data2);
		}

		// System.out.println("firsthalf empty="+firstHalf.isEmpty());
		// System.out.println("secondhalf empty="+secondHalf.isEmpty());
		// mergeQueue.show();
		return mergeQueue;
	}

	@SuppressWarnings("unused")
	public static <T> LinkedQueue<T> mergeUsingDEQ(LinkedQueue<T> queue) throws QueueException, DEQException, StackException {
		DoublyEndedQueue<T> deq = new DoublyEndedQueue<T>();
		StackUsingQueue<T> stack = new StackUsingQueue<T>();
		LinkedQueue<T> leftHalf = new LinkedQueue<T>();
		LStack<T> rightHalf = new LStack<T>();
		LinkedQueue<T> merge = new LinkedQueue<T>();

		while (!queue.isEmpty())
			deq.enQueueRear(queue.deQueue());

		// store left half data in queue
		// and right half data in stack
		while (!deq.isEmpty()) {
			leftHalf.enQueue(deq.deQueueFront());
			if (!deq.isEmpty())
				rightHalf.push(deq.deQueueRear());
			else
				break;
		}

		while ((!leftHalf.isEmpty()) && (!rightHalf.isEmpty())) {
			merge.enQueue(leftHalf.deQueue());
			merge.enQueue(rightHalf.pop());
		}

		while (!leftHalf.isEmpty()) {
			merge.enQueue(leftHalf.deQueue());
		}

		while (!rightHalf.isEmpty()) {
			merge.enQueue(rightHalf.pop());
		}
		return merge;
	}

}
