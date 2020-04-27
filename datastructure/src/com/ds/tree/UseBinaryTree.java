package com.ds.tree;

import com.ds.exception.QueueException;

public class UseBinaryTree {
	public static void main(String[] args) {
		BinaryTree<Integer> b1 = new BinaryTree<Integer>();
		try {
			b1.insert(100);
			b1.insert(20);
			b1.insert(130);
//			b1.levelOrderTraverse();
			b1.insert(40);
			b1.insert(50);
			b1.insert(60);
			b1.insert(-90);
//			b1.insert(-90);
//			b1.insert(90);
			
//			System.out.println("height="+b1.heightIterative());
//			b1.levelOrderTraverse();
//			System.out.println("total leaves="+totalLeaves(b1));
//			System.out.println("Full nodes = "+totalFullNodes(b1));
//			System.out.println("Number of one nodes="+totalSingleNodes(b1));
			System.out.println("maximum="+maximumLevelSum(b1));
		} catch (QueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static<T> int totalLeaves(BinaryTree<T> bt) throws QueueException	{
		return bt.numberOfLeaves();
	}

	public static<T> int totalFullNodes(BinaryTree<T> bt) throws QueueException	{
		return bt.numberOfFullNodes();
	}

	public static<T> int totalSingleNodes(BinaryTree<T> bt) throws QueueException	{
		return bt.numberOfOneNodes();
	}
	
	public static<T> int maximumLevelSum(BinaryTree<T> tree) throws QueueException	{
		return tree.maximumSumLevel();
	}

}
