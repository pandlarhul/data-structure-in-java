package com.ds.tree;

import com.ds.exception.QueueException;
import com.ds.exception.StackException;
import com.ds.queue.LinkedQueue;
import com.ds.stack.LStack;

public class TreeTraversal {

	public static void preOrder(Node root) {
		if (root != null) {
			System.out.println(" " + root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}


	public static void nonRecursivePreOrder(Node root) throws StackException {
		if (root == null) {
			return;
		}

		LStack<Node> stack = new LStack<Node>();
		while (true) {
			while (root != null) {
				stack.push(root);
				System.out.print(" " + root.data);
				root = root.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			root = stack.pop();
				root = root.right;
			
		}
//		while (!stack.isEmpty()) {
//			root = stack.pop();
//			if (root.right != null) {
//				root = root.right;
//				while (root != null) {
//					System.out.print("  " + root.data);
//					stack.push(root);
//					root = root.left;
//				}
//
//			}
//
//		}
	}

	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(" " + root.data);
			inOrder(root.right);
		}
	}

	public static void inOrderIterative(Node root) throws StackException {
		LStack<Node> stack = new LStack<Node>();
		while (true) {
			
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			System.out.print(" " + root.data);
				root = root.right;

		}
	}
	public static<T> void postOrderIterative(Node root) throws StackException {
		LStack<Node> stack = new LStack<Node>();
		Node pre = null;
		do {
			while(root != null)	{
				stack.push(root);
				root = root.left;
			}
			while(root == null && !stack.isEmpty())	{
				root = stack.peek();
				if(root .right == null || root.right == pre) {
					System.out.print(" "+root.data);
					root = stack.pop();
					pre = root;
					root = null;
				} else {
					root = root.right;
				}
			}
			
		}while(!stack.isEmpty());
	}
	

	
	public static void levelOrderReverse(Node root) throws QueueException, StackException	{
		Node top = root;
		if(top == null)
			return;
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		LStack<Node> stack = new LStack<Node>();
		queue.enQueue(top);
		
		while(!queue.isEmpty())	{
			top = queue.deQueue();
			
			
			if(top.left != null) {
				queue.enQueue(top.left);
			}
			if(top.right != null) {
				queue.enQueue(top.right);
			}
			stack.push(top);
		}
		
		while(!stack.isEmpty())	{
			System.out.print("  "+stack.pop().data);
		}
		
		
		
	}


}
