package com.ds.linkedlist;

public class MergeSortedLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.addUsingHashMap(11);
		list1.addUsingHashMap(15);
		list1.addUsingHashMap(25);
		list1.addUsingHashMap(100);

		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.addUsingHashMap(1);
		list2.addUsingHashMap(14);
		list2.addUsingHashMap(16);
		list2.addUsingHashMap(20);
		list2.addUsingHashMap(50);

		LinkedList<Integer>.Node<Integer> ptr1 = list1.head;
		LinkedList<Integer>.Node<Integer> ptr2 = list2.head;

		LinkedList<Integer>.Node<Integer> result = mergeUsingRecursive(ptr1, ptr2);

//		
//		while(ptr1 != null && ptr2!= null)	{
//			if(ptr1.data < ptr2.data) {
//				result.addUsingHashMap(ptr1.data);
//				ptr1 = ptr1.next;
//			} else {
//				result.addUsingHashMap(ptr2.data);
//				ptr2 = ptr2.next;
//			}
//		}
//		
//		while(ptr1 != null)	{
//			result.addUsingHashMap(ptr1.data);
//			ptr1 = ptr1.next;
//		}
//		
//		while(ptr2 != null)	{
//			result.addUsingHashMap(ptr2.data);
//			ptr2 = ptr2.next;
//		}

		while (result != null) {
			System.out.println(result.data);
			result = result.next;
		}
	}

	public static LinkedList<Integer>.Node<Integer> mergeUsingRecursive(LinkedList<Integer>.Node<Integer> p1,
			LinkedList<Integer>.Node<Integer> p2) {
		if (p1 == null) {
			return p2;
		}
		if (p2 == null) {
			return p1;
		}
		LinkedList<Integer>.Node<Integer> result;
		if (p1.data <= p2.data) {
			result = p1;
			result.next = mergeUsingRecursive(p1.next, p2);
		} else {
			result = p2;
			result.next = mergeUsingRecursive(p1, p2.next);
		}
		return result;
	}

}
