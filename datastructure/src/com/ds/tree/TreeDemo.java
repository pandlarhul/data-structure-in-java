package com.ds.tree;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.ds.exception.QueueException;
import com.ds.exception.StackException;
import com.ds.exception.TreeException;
import com.ds.queue.LinkedQueue;
import com.ds.stack.LStack;

class Node {
	int data;
	Node left;
	Node right;
	int remaining;

	public Node(int data) {
		this.data = data;
	}

}

public class TreeDemo {
	public static Node tree1() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.left = n2;
		n1.right = n3;
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n2.left = n4;
		n2.right = n5;
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		n3.left = n6;
		n3.right = n7;
		Node root = n1;
		return root;
	}

	/*
	 * @operation- create a fixed tree.
	 * 
	 * @param - void
	 * 
	 * @return - 1d Array of Node type of length 2 where
	 * 
	 * @exception
	 */
	public static Node[] tree2() throws QueueException {
		Node[] listNode = new Node[3];
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.left = n2;
		n1.right = n3;
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n2.left = n4;
		n2.right = n5;
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		n3.left = n6;
		n3.right = n7;
		Node root = n1;
		root = mirror(root);
		listNode[0] = root;
		listNode[1] = n4;
		listNode[2] = n5;
		return listNode;
	}

	public static void main(String[] args) throws QueueException {

		/*
		 * diameter of the tree
		 */
		// System.out.println("=" + diameter1(root));

		/*
		 * check that the given sum exist in any path starting with root
		 */
		// List<Integer> list = new LinkedList<Integer>();
		// System.out.println(sumExist(root, 3));

		/*
		 * printing all path of the trees starting from root
		 */
		// printAllNode(root, list, 0);

		/*
		 * find the least common ancestor of given two nodes
		 */

		// Node tree1 = tree1();
//		Node listNode[] = tree2();
//		Node root = listNode[0];
//		Node left = listNode[1];
//		Node right = listNode[2];
//		
		// Node lcaNode = LCA(root, left, right);

		// levelOrderTraverse(tree);
//		tree = mirror(tree);
//		levelOrderTraverse(tree);

		// System.out.println("\nleast common ancesstor node="+lcaNode.data+" for "+
		// left.data + " and "+right.data);

		// Node mirrorRoot = mirror(tree1);
//		System.out.println();
//		levelOrderTraverse(tree2);

		// System.out.println(areMirrorOfEachOther(root, mirrorRoot));

		// System.out.println();
		// System.out.println(ptr);

		/*
		 * construct a binary tree from inorder and preorder
		 */
//		int preOrder[] = { 1, 2, 4, 5, 3, 6 };
//		int inOrder[] = { 4, 2, 5, 1, 3, 6 };
//		int postOrder[] = {4, 5, 2, 6, 3, 1};
//		int start = 0;
//		int end = preOrder.length - 1;
//
//		Node root;
//		try {
//			root = buildTreeFromInAndPreOrder(inOrder, preOrder, start, end, start);
//			//preOrder(root);
//			levelOrderTraverse(root);
//		} catch (TreeException e) {
//			e.printStackTrace();
//		}

//		Node allAncestors = tree1();
//		allAncestors(allAncestors, 5);

		Node root = tree1();
//		try {
//			allAncestorsDFS(root, 5);
//		} catch (StackException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			zigZag2(root);
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void allAncestorsDFS(Node root, int a) throws StackException {
		LStack<Node> stack = new LStack<>();
		Node temp = root;
		if (temp == null) {
			System.out.println("Tree is empty");
			return;
		}
		while (true) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			temp = stack.pop();

			if (temp.data == a) {
				stack.push(temp);

				break;
			}
			// System.out.print(" " + temp.data);
			temp = temp.right;
		}
		if (stack.isEmpty()) {
			System.out.println("Element is not present in the available tree");
		} else {

			while (!stack.isEmpty()) {
				temp = stack.pop();
				System.out.println(" " + temp.data);

			}
		}
	}

	/*
	 * @operation - This method will create a binary tree from preorder and inorder
	 * element
	 * 
	 * @param - inOrder, preOrder, startIndex(0), endIndex(array length -1 )
	 * 
	 * @return- return the root node of constructed tree.
	 */
	public static Node buildTreeFromInAndPreOrder(int inOrder[], int preOrder[], int startInIndex, int endInIndex,
			int start) throws TreeException {

		// check that the element are same
		if (inOrder.length != preOrder.length) {
			throw new TreeException(2);
		}

//		System.out.println("start ="+start);
//		
//		
//		if (start > inOrder.length) {
//			return null;
//		}
//		
		if (startInIndex > endInIndex) {
			return null;
		}

		// get the value from preorder array at index and increment the index
		int preOrderValue = preOrder[start];

		// create the node of the tree for the above preorder value
		Node root = new Node(preOrderValue);

		// get the position from inorder array for the preorder value
		int position = getIndex(inOrder, preOrderValue, startInIndex, endInIndex);

		System.out.println("position = " + position + " " + preOrderValue);

		// pass the
		start++;
		Node left = buildTreeFromInAndPreOrder(inOrder, preOrder, startInIndex, position - 1, start);
		start++;
		Node right = buildTreeFromInAndPreOrder(inOrder, preOrder, position + 1, endInIndex, start);
		start++;
		root.left = left;
		root.right = right;
		return root;
	}

	private static int getIndex(int[] inOrder, int value, int startIndex, int endIndex) throws TreeException {

		int i = 0;
		for (i = startIndex; i <= endIndex; i++) {
			if (inOrder[i] == value)
				return i;
		}
		throw new TreeException(3);
	}

	public static boolean allAncestors(Node root, int data) {

		if (root == null) {
			return false;
		}

		if (root.data == data) {
			return true;
		}
		boolean b1 = allAncestors(root.left, data);
		boolean b2 = allAncestors(root.right, data);

		if (b1 == true) {
			System.out.println(root.data);
			return true;
		}
		if (b2 == true) {
			System.out.println(root.data);
			return true;
		}
		return false;

	}

	/*
	 * @operation = traverse a tree in zig-zag way
	 * 
	 * @param root = root node of a tree
	 * 
	 * @return void
	 */
	public static void zigZagTraverse(Node root) throws QueueException, StackException {
		Node temp = root;
		boolean ltr = true;
		LinkedQueue<Node> queue = new LinkedQueue<>();
		LinkedQueue<Node> printQueue = new LinkedQueue<>();
		LStack<Node> stack = new LStack<>();

		queue.enQueue(temp);
		queue.enQueue(null);

		while (!queue.isEmpty()) {
			temp = queue.deQueue();

			if (temp == null) {
				if (ltr == true) {
					while (!printQueue.isEmpty()) {
						System.out.println(" " + printQueue.deQueue().data);
					}
				} else if (ltr == false) {
					while (!stack.isEmpty()) {
						System.out.println(" " + stack.pop().data);
					}
				}
				ltr = ltr == true ? false : true;
				if (!queue.isEmpty())
					queue.enQueue(null);

			} else {
				if (temp.left != null) {
					queue.enQueue(temp.left);
					if (ltr == true) {
						printQueue.enQueue(temp.left);
					} else {
						stack.push(temp.left);
					}
				}
				if (temp.right != null) {
					queue.enQueue(temp.right);
					if (ltr == true) {
						printQueue.enQueue(temp.right);
					} else {
						stack.push(temp.right);
					}
				}

			}
		}

	}

	public static void zigZag2(Node root) throws StackException {
		Node temp = root;
		LStack<Node> currentLevel = new LStack<Node>();
		LStack<Node> nextLevel = new LStack<Node>();
		int ltr = 1;
		currentLevel.push(temp);
		while (!currentLevel.isEmpty()) {
			temp = currentLevel.pop();
			if (temp != null) {
				System.out.println(" " + temp.data);
				if (ltr == 1) {
					if (temp.left != null)
						nextLevel.push(temp.left);
					if (temp.right != null)
						nextLevel.push(temp.right);
				} else {
					if (temp.right != null)
						nextLevel.push(temp.right);
					if (temp.left != null)
						nextLevel.push(temp.left);

				}
			}
			if(currentLevel.isEmpty()) {
				ltr = 1 - ltr;
				LStack<Node> t = currentLevel;
				currentLevel = nextLevel;
				nextLevel = t;
			}

		}

	}

	static int ptr = 0;

	public static int diameter(Node root) {
		int left = 0;
		int right = 0;
		if (root == null) {
			return 0;
		} else {
			left = diameter(root.left);
			right = diameter(root.right);

			if (left + right > ptr) {
				ptr = left + right;
			}
			System.out.println(ptr);

		}
		return Math.max(left, right) + 1;
	}

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

	public static <T> void postOrderIterative(Node root) throws StackException {
		LStack<Node> stack = new LStack<Node>();
		Node pre = null;
		do {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			while (root == null && !stack.isEmpty()) {
				root = stack.peek();
				if (root.right == null || root.right == pre) {
					System.out.print(" " + root.data);
					root = stack.pop();
					pre = root;
					root = null;
				} else {
					root = root.right;
				}
			}

		} while (!stack.isEmpty());
	}

	public static void levelOrderTraverse(Node root) throws QueueException {

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
	}

	public static int diameter1(Node root) {
		int lHeight = 0;
		int rHeight = 0;
		int ld = 0;
		int rd = 0;
		if (root == null) {
			return 0;
		}
		lHeight = height(root.left);
		rHeight = height(root.right);
		ld = diameter1(root.left);
		rd = diameter1(root.right);

		return Math.max(lHeight + rHeight + 1, Math.max(ld, rd));

	}

	public static int height(Node root) {
		int left = 0;
		int right = 0;
		if (root == null) {
			return 0;
		} else {
			left = height(root.left);
			right = height(root.right);
		}
		return Math.max(left, right) + 1;
	}

	public static void printAllNode(Node root, List<Integer> list, int length) {
		System.out.println();
		if (root == null) {
			return;
		}
		list.add(length, root.data);
		System.out.println("index=" + length + " root=" + root.data);
		length += 1;
		if (root.left == null && root.right == null) {
			printList(list, length);
		} else {
			printAllNode(root.left, list, length);
			printAllNode(root.right, list, length);
		}
	}

	private static void printList(List<Integer> list, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(" " + list.get(i));
		}
	}

	public static boolean isSumExist(Node root, List<Integer> list, int length, int sum) {
		if (root == null) {
			return (calculateSum(list, length, sum));
		}
		list.add(length, root.data);
		length++;

		isSumExist(root.left, list, length, sum);
		isSumExist(root.right, list, length, sum);
		return false;

	}

	private static boolean calculateSum(List<Integer> list, int length, int sum) {
		System.out.println(list + " " + sum + " length=" + length);
		int total = 0;
		for (int i = 0; i < length; i++) {
			total += list.get(i);
			if (total == sum) {
				return true;
			}
		}
		return false;

	}

	public static boolean sumExist(Node root, int sum) throws QueueException {
		Node temp = root;
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		root.remaining = sum - root.data;

		queue.enQueue(root);
		queue.enQueue(null);
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (temp == null) {
				if (!queue.isEmpty())
					queue.enQueue(null);
			}

			else {
				if (temp.remaining == 0) {
					return true;
				}

				if (temp.left != null) {
					temp.left.remaining = temp.remaining - temp.left.data;
					queue.enQueue(temp.left);
				}
				if (temp.right != null) {
					temp.right.remaining = temp.remaining - temp.right.data;
					queue.enQueue(temp.right);
				}
			}
		}
		return false;

	}

	public static Node mirror(Node root) throws QueueException {
		Node temp = root;
		LinkedQueue<Node> queue = new LinkedQueue<Node>();
		Node temp1 = null;

		queue.enQueue(root);

		while (!queue.isEmpty()) {
			temp = queue.deQueue();

			temp1 = temp.left;
			temp.left = temp.right;
			temp.right = temp1;

			if (temp.left != null) {
				queue.enQueue(temp.left);
			}
			if (temp.right != null) {
				queue.enQueue(temp.right);
			}
		}
		return root;

	}

	public static Node mirrorRecursive(Node root) throws QueueException {
		if (root != null) {
			mirrorRecursive(root.left);
			mirrorRecursive(root.right);
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}

	public static boolean areMirrorOfEachOther(Node root1, Node root2) {
		System.out.println(root1.data + " " + root2.data);

		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null)
			return false;
		if (root1.data != root2.data) {
			return false;
		}
		return areMirrorOfEachOther(root1.left, root2.right) && areMirrorOfEachOther(root1.right, root2.left);

	}

	public static boolean areMirror(Node root1, Node root2) throws QueueException {
		System.out.println("cal");
		Node temp1 = root1;
		Node temp2 = root2;
		if (root1 == null && root2 == null) {
			return true;
		}
		LinkedQueue<Node> queue1 = new LinkedQueue<Node>();
		queue1.enQueue(root1);

		LinkedQueue<Node> queue2 = new LinkedQueue<Node>();
		queue2.enQueue(root2);

		while ((!queue1.isEmpty()) && (!queue2.isEmpty())) {
			temp1 = queue1.deQueue();
			temp2 = queue2.deQueue();
			System.out.println(temp1.data + " " + temp2.data);

			if (temp1.data == temp2.data) {
				if (temp1.left != null && temp2.right != null) {
					queue1.enQueue(temp1.left);
					queue2.enQueue(temp2.right);
				}
				if (temp1.right != null && temp2.left != null) {
					queue1.enQueue(temp1.right);
					queue2.enQueue(temp2.left);
				}
			} else {
				return false;
			}
		}

		if (queue1.isEmpty() && queue2.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static Node LCA(Node root, Node a, Node b) {
		// System.out.println(root.data+" "+a.data+" "+b.data);
		Node left;
		Node right;
		if (root == null) {
			return root;
		}
		if (root == a || root == b) {
			return root;
		}
		left = LCA(root.left, a, b);
		right = LCA(root.right, a, b);
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		return root;
	}

}
