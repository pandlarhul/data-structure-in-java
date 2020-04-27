package com.ds.tree;

import com.ds.exception.QueueException;
import com.ds.queue.LinkedQueue;

public class SizeOfTheTree {
	public static int sizeIterative(Node root) throws QueueException	{
		if(root == null) {
			return 0;
		}
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		int size = 0;
		queue.enQueue(root);
		while(!+queue.isEmpty())	{
			root = queue.deQueue();
			size++;
			if(root.left != null) {
				queue.enQueue(root.left);
			} 
			if(root.right != null) {
				queue.enQueue(root.right);
			}
			
		}
		return size;
	}
	public static int size(Node root)	{
		int size = 0;
		if(root != null) {
			size = 1;
			if(root.left != null)
				size += size(root.left);
			if(root.right != null)
				size += size(root.right);
			return size;
		}
		return 0;
	}


}
