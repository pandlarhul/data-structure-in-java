package com.ds.tree;

import com.ds.exception.QueueException;
import com.ds.exception.StackException;
import com.ds.exception.TreeException;
import com.ds.queue.LinkedQueue;
import com.ds.stack.LStack;

public class MaximumElement {
	public static void main(String args[])	{
		Node n1 = new Node(-90);
		Node n2 = new Node(-21);
		Node n3 = new Node(-343);
		n1.left = n2;
		n1.right = n3;
		Node n4 = new Node(-4770);
		Node n5 = new Node(-51);
		n2.left = n4;
		n2.right = n5;
		Node n6 = new Node(10);
		Node n7 = new Node(-7120);
		n3.left = n6;
		n3.right = n7;
		Node root = n1;
		int max;
		try {
			//max = maximum(root);
			//max = maxIterative(root);
			max = maxLevelOrderTraversal(root);
			System.out.println("max="+max);
		} catch (QueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static int maximum(Node root) throws TreeException	{
		int left = 0;
		int right = 0;
		int max = 0;
		if(root == null) {
			throw new TreeException(0);
		}else if(root.left == null && root.right == null) {
			return root.data;
		}
		max = root.data;
		 if(root.left != null)	{
			left = maximum(root.left);
		}
		 if(max < left) {
			 max = left;
		 }
		 if(root.right != null) {
			 right = maximum(root.right);
		 }
		 if(max < right)
			 max = right;
		 return max;
	}
	public static int maxIterative(Node root) throws StackException, QueueException	{
		int max = -99999;
		LStack<Node> stack = new LStack<Node>();
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		while(true) {
			while(root != null)	{
				stack.push(root);
				root = root.left;
			}
			
			if (stack.isEmpty()) {
				break;
			} else {
				root = stack.pop();
				queue.enQueue(root.data);
				root = root.right;
			}
		}
		int deQueueData = 0;
		while(!queue.isEmpty())	{
			deQueueData = queue.deQueue();
			if(deQueueData > max)
				max  = deQueueData;
		}
		return max;
	}
	public static int maxLevelOrderTraversal(Node root) throws QueueException	{
		int max = -99999;
		Node temp = null;
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		queue.enQueue(root);
		while(!queue.isEmpty())	{
			temp = queue.deQueue();
			if(temp.data > max) {
				max = temp.data;
			}
			if(temp.left != null) {
				queue.enQueue(temp.left);
			}
			if(temp.right != null) {
				queue.enQueue(temp.right);
			}
		}
		return max;
	}

}
