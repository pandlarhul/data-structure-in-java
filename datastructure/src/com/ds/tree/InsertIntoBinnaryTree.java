package com.ds.tree;

import com.ds.exception.QueueException;
import com.ds.exception.StackException;
import com.ds.queue.LinkedQueue;

public class InsertIntoBinnaryTree {
	public static void main(String[] args) {
		Node n1 = new Node(0);
		try {
			insert(n1, 10);
			insert(n1, 20);
			insert(n1, 30);
			insert(n1, 40);
			insert(n1, 50);
			insert(n1, 60);
			
			TreeTraversal.levelOrderTraverse(n1);
			System.out.println("\nfind 60="+BinaryTreeSearching.searchUsingPreorder(n1, 60));
			System.out.println("Size = "+SizeOfTheTree.sizeIterative(n1));
			System.out.println("reverse Level oredr =\n");
			TreeTraversal.levelOrderReverse(n1);
		} catch (QueueException | StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
