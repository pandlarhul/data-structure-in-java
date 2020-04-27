package com.ds.linkedlist;

public class ReOrderLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(11);
		list1.add(22);
		list1.add(33);
		list1.add(44);
		list1.add(55);
		list1.add(66);
		list1.add(77);
		list1.add(88);
		System.out.println("result list");
		LinkedList<Integer>.Node<Integer> result =reorder(list1);
		while(result != null)	{
			System.out.println(result.data);
			result = result.next;
		}

	}
	public static LinkedList<Integer>.Node<Integer> reorder(LinkedList<Integer> list)	{
		LinkedList<Integer>.Node<Integer> ptr1x = list.head;
		LinkedList<Integer>.Node<Integer> ptr2x = ptr1x;
		while(ptr2x != null && ptr2x.next != null)	{
			ptr1x = ptr1x.next;
			ptr2x = ptr2x.next.next;
		}
		
//		System.out.println("ptr1x.data="+ptr1x.data);
//		System.out.println("ptr2x.data="+ptr2x.data);
//		
		LinkedList<Integer>.Node<Integer> head;
		LinkedList<Integer>.Node<Integer> tail,current;
		 current = list.head;
		
		
		LinkedList<Integer>.Node<Integer> temp = null, pre = null;
		
		
		while(current != ptr1x )	{
			System.out.println("current.dara="+current.data);
			temp = current .next;
			current.next = pre;
			
			
			pre = current; 
			current = temp;
		}
		//System.out.println(pre.data);
		//pre.next = ptr1x;
		ptr2x = ptr1x;
		ptr1x = pre;
		LinkedList<Integer>.Node<Integer> temp1 = null, temp2 = null;
		while(ptr1x != null && ptr2x != null)	{
			temp1 = ptr1x.next;
			temp2 = ptr2x.next;
			ptr1x.next = ptr2x;
			ptr2x.next = temp1;
			ptr2x = temp2;
			ptr1x = temp1;
		}
		
		return pre;
	}


}
