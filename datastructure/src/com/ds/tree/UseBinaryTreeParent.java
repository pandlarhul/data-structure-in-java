package com.ds.tree;

import com.ds.exception.QueueException;
import com.ds.exception.TreeException;

public class UseBinaryTreeParent {
	public static void main(String[] args) {
		TreeWithParentProperty<Integer> tree = new TreeWithParentProperty<Integer>();
		
		try {
			tree.insert(10);
			tree.insert(20);
			tree.insert(30);
			tree.insert(40);
			System.out.println("Before deleting");
			tree.levelOrderTraverse();
			tree.deleteNode(20);
			System.out.println("\nAfter deleting 20=");
			tree.levelOrderTraverse();
//			tree.levelOrderTraverse();
		} catch (QueueException | TreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
