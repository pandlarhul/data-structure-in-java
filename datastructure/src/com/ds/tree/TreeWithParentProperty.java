package com.ds.tree;

import com.ds.exception.QueueException;
import com.ds.exception.TreeException;
import com.ds.queue.LinkedQueue;
import com.ds.tree.BinaryTree.Node;

public class TreeWithParentProperty<T> {
	private Node root;

	class Node {
		T data;
		Node left;
		Node right;
		Node parent;

		public Node(T data) {
			this.data = data;
			left = null;
			right = null;
			parent = null;
		}
	}

	public void insert(T data) throws QueueException {
		Node temp = root;
		Node n1 = new Node(data);
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		if (root == null) {
			root = n1;
			return;
		}
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			root = queue.deQueue();
			if (root.left == null) {
				root.left = n1;
				n1.parent = root;
				break;
			} else {
				queue.enQueue(root.left);
			}

			if (root.right == null) {
				root.right = n1;
				n1.parent = root;
				break;
			} else {
				queue.enQueue(root.right);
			}
		}
		root = temp;
	}

	public void levelOrderTraverse() throws QueueException {
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		Node top = null;
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			top = queue.deQueue();
			System.out.print("  " + top.data);

			if (top.left != null) {
				queue.enQueue(top.left);
			}
			if (top.right != null) {
				queue.enQueue(top.right);
			}
		}
		// root = temp;
	}

	public Node isContains(T data) throws QueueException {
		Node top = root;
		if (top == null)
			return null;

		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		queue.enQueue(top);

		while (!queue.isEmpty()) {
			top = queue.deQueue();
			if (top.data == data) {
				return top;
			}
			if (top.left != null)
				queue.enQueue(top.left);
			if (top.right != null)
				queue.enQueue(top.right);
		}
		return null;
	}

	public void deleteNode(T data) throws TreeException, QueueException {
		
		// get deleting node location
		Node tempData = isContains(data);
		
		// get deepest node
		Node deepest = deepestNode();
	
		// get parent of the deepest node
		Node parentTemp = deepest.parent;
		
		// if deleting element is available
		if (isContains(data) != null) {

			// swap deepest with deleting element
			T tempSwap = deepest.data;
			deepest.data = tempData.data;
			tempData.data = tempSwap;
						
			if (parentTemp.right != null) {
				parentTemp.right = null;
			} else if(parentTemp.left != null){
				parentTemp.left = null;
			}
		} else
			throw new TreeException(1);

	}

	public Node deepestNode() throws QueueException {
		Node temp = root;

		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		queue.enQueue(temp);
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (temp.left != null)
				queue.enQueue(temp.left);
			if (temp.right != null)
				queue.enQueue(temp.right);

		}
		return temp;
	}

}
