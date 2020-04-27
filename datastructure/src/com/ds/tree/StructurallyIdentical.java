package com.ds.tree;

import com.ds.exception.QueueException;

public class StructurallyIdentical {
	
	public static void main(String[] args) {
		BinaryTree<Integer> b1 = new BinaryTree<Integer>();
		BinaryTree<Integer> b2 = new BinaryTree<Integer>();
		try {
			b1.insert(10);
			b1.insert(20);
			b1.insert(30);
			b1.insert(40);
			
			b2.insert(10);
			b2.insert(20);
			b2.insert(30);
			b2.insert(40);
			//b2.insert(50);
			System.out.println(isStructuralIdentical(b1.root, b2.root));
		} catch (QueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static boolean isStructuralIdentical(BinaryTree.Node root1, BinaryTree.Node root2)	{
		if(root1 == null && root2 == null) {
			return true;
		}
		else if(root1 == null || root2 == null){
			return false;
		}
		else {
			return (isStructuralIdentical(root1.left, root2.left))&& isStructuralIdentical(root1.right, root2.right);
		}
	}
	

}
