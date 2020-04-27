package com.ds.tree;

import com.ds.exception.QueueException;
import com.ds.queue.LinkedQueue;

public class BinaryTree<T> {
	Node root;

	class Node {
		T data;
		Node left;
		Node right;

		public Node(T data) {
			this.data = data;
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
				break;
			} else {
				queue.enQueue(root.left);
			}

			if (root.right == null) {
				root.right = n1;
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

	public int height(Node root) {

		int left = 0;
		int right = 0;
		int max = 0;

		if (root == null) {
			return 0;
		} else {
			left = height(root.left);
			right = height(root.right);
			max = left > right ? left : right;
			return max + 1;
		}

	}

	public int heightIterative() throws QueueException {
		int level = 0;
		Node temp = root;
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		queue.enQueue(temp);
		queue.enQueue(null);

		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (temp == null) {
				level += 1;
				if (!queue.isEmpty())
					queue.enQueue(null);
			} else {
				if (temp.left != null)
					queue.enQueue(temp.left);
				if (temp.right != null)
					queue.enQueue(temp.right);
			}
		}

		return level;
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

	public int numberOfLeaves() throws QueueException {
		Node temp = root;
		int leaves = 0;
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		queue.enQueue(temp);

		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (temp.left == null && temp.right == null) {
				leaves += 1;
			} else {
				if (temp.left != null) {
					queue.enQueue(temp.left);
				}
				if (temp.right != null) {
					queue.enQueue(temp.right);
				}
			}
		}
		return leaves;
	}

	public int numberOfFullNodes() throws QueueException {
		Node temp = root;
		int leaves = 0;
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		queue.enQueue(temp);

		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			
			if (temp.left != null && temp.right != null)
				leaves += 1;

			if (temp.left != null) {
				queue.enQueue(temp.left);
			}
			if (temp.right != null) {
				queue.enQueue(temp.right);
			}

		}
		return leaves;
	}
	
/*
 * 
 */
	public int numberOfOneNodes() throws QueueException {
		Node temp = root;
		int leaves = 0;
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		queue.enQueue(temp);
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if ((temp.left == null && temp.right != null)|| (temp.right == null && temp.left != null))
				leaves += 1;
			if (temp.left != null) {
				queue.enQueue(temp.left);
			}
			if (temp.right != null) {
				queue.enQueue(temp.right);
			}
		}
		return leaves;
	}
	
	public<T extends Integer> int maximumSumLevel() throws QueueException	{
		Node temp = root;
		int max  = -9999999;
		int level = 0;
		int preLevel = 0;
		int current = 0;
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		queue.enQueue(temp);
		queue.enQueue(null);
		
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if(temp == null) {
				if(current > max ) {
					max = current;
					level = preLevel;
				}
				if(!queue.isEmpty()) {
					queue.enQueue(null);
				}
				preLevel ++ ;
				current = 0;
			}else {
				current += (T)temp.data;
				if(temp.left != null) {
					queue.enQueue(temp.left);
				}
				if(temp.right != null) {
					queue.enQueue(temp.right);
				}
			}
		}
		return level;
	}
	

}
