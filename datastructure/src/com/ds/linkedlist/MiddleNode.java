package com.ds.linkedlist;

public class MiddleNode {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addUsingHashMap(10);
		list.addUsingHashMap(20);
		list.addUsingHashMap(30);
		list.addUsingHashMap(40);
		list.addUsingHashMap(50);
		list.addUsingHashMap(60);
		list.addUsingHashMap(70);
//		System.out.println(list);
		int size = list.size();
		size /= 2;
		LinkedList<Integer>.Node<Integer> ptr1x = list.head;
		LinkedList<Integer>.Node<Integer> ptr2x = list.head;
		while(ptr2x.next != null && ptr2x != null && ptr2x.next.next!= null)	{
			ptr1x = ptr1x.next;
			ptr2x = ptr2x.next.next;
		}
		System.out.println("middle = "+ptr1x.data);
	}

}
