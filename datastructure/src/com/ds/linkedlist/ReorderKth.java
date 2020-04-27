package com.ds.linkedlist;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class ReorderKth {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(55);
		list.add(66);
		list.add(77);
		list.add(88);
		int k = 2;
		LinkedList<Integer>.Node<Integer> node = reOrderKTh(list, k);

		int i =0;
		while (node != null && i++ < 10) {
			System.out.print("  " + node.data);
			node  = node.next;
		}

	}

	/*
	 * Functionality : check if the remaining list contains k nodes or not
	 * 
	 * @param : current node , int k
	 * 
	 * @return : boolean
	 */
	public static boolean hasKNodes(LinkedList<Integer>.Node<Integer> head, int k) {
		int i = 0;
		for (i = 0; i < k && head != null; i++) {
			head = head.next;
		}
		if (i == k)
			return true;
		else
			return false;

	}

	/*
	 * Functionality : reverse the pair of K node
	 * 
	 * @param : List(list), Integer(k)
	 * 
	 * @return : The original list will be reflected by pointer in main function
	 */

	@SuppressWarnings({ "unused", "null" })
	public static LinkedList<Integer>.Node<Integer> reOrderKTh(LinkedList<Integer> list, int k) {
		int i = 0;

		LinkedList<Integer>.Node<Integer> head = list.head, temp = null, tail = head;
		LinkedList<Integer>.Node<Integer> temp1 = null;
		LinkedList<Integer>.Node<Integer> pre = null;
		LinkedList<Integer>.Node<Integer> tempHead = null;
		LinkedList<Integer>.Node<Integer> mainHead = null;
		LinkedList<Integer>.Node<Integer> preHead = null;
		LinkedList<Integer>.Node<Integer> preTail = null;
		LinkedList<Integer>.Node<Integer> ptr = null,preTail1 = null;

		

		while (hasKNodes(head, k) && head!= null) {
			System.out.println(hasKNodes(head, k));	
			System.out.println("head main = "+head.data);
			i = 0;
			tail = head;

			temp = kPlusOneTh(head, k);
			//System.out.println("k+1="+temp.data);
			pre = null;
			while (i < k) {
				temp1 = head.next;
				head.next = pre;
				pre = head;
				head = temp1;
				i++;
			}
			
			
			
			if (tempHead == null) {
				mainHead = pre;
				tail.next = null;
			} else {
				preTail.next = pre;
			}
			tempHead = pre;
			preTail = tail;
			

//			System.out.println("head.data=" + tempHead.data);
//			System.out.println("head.next.data=" + tempHead.next.data);
//			System.out.println("head.next.next.data=" + tempHead.next.next.data);
//			System.out.println("tail.data=" + tail.data);
			//System.out.println("tail.next.data=" + tail.next.data);
			
			

//			System.out.println("ptr.data="+ptr.data);
//			System.out.println("ptr.next.data="+ptr.next.data);
			head = temp;
		}
		
//		System.out.println("pre.data="+pre.data);
//		System.out.println("pre.next.data="+pre.next.data);
//		System.out.println("head.data="+head.data);

		ptr = head;
		System.out.println("sublist\n");
		i = 0;
		while(ptr != null && i++ < 10)	{
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
		System.out.println("sublist\n");
		  

		
		
		if(head == null) {
			preTail.next = null;
		} else {
			preTail.next = head;
		}
		//pre.next = tempHead;

		return mainHead;
	}

	public static LinkedList<Integer>.Node<Integer> kPlusOneTh(LinkedList<Integer>.Node<Integer> head, int k) {
		LinkedList<Integer>.Node<Integer> mainHead = head;
		for (int i = 0; i < k && head != null; i++) {
			head = head.next;
		}
		return head;
	}

}
