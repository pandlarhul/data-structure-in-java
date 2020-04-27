package com.ds.tree;

import com.ds.exception.QueueException;
import com.ds.queue.LinkedQueue;

public class BinaryTreeSearching {
	public static void main(String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		n1.left = n2;
		n1.right = n3;
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		n2.left = n4;
		n2.right = n5;
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		n3.left = n6;
		n3.right = n7;
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		n6.left = n8;
		n8.right = n9;
		Node root = n1;
		//System.out.println(searchUsingPreorder(root, 0x50));
		try {
			System.out.println(searchUsingIterative(root, 80));
		} catch (QueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean searchUsingPreorder(Node root, int data) {
		if (root != null) {
			if (root.data == data) {
				return true;
			} else if (searchUsingPreorder(root.left, data))
				return true;
			else if (searchUsingPreorder(root.right, data))
				return true;
		}
		return false;
	}

	public static boolean searchUsingIterative(Node root ,int data) throws QueueException	{
		if(root == null)
			return false;
		
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		queue.enQueue(root);
		
		while(!queue.isEmpty())	{
			root = queue.deQueue();
			if(root.data == data) {
				return true;
			}
			if(root.left != null)
				queue.enQueue(root.left);
			if(root.right != null)
				queue.enQueue(root.right);
		}
		
		return false;
	}

}
