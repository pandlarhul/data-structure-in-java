package com.ds.linkedlist;

public class Palindrome {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = list1;
		list1.add(1);
		list1.add(7);
		list1.add(5);
		list1.add(3);
		//list1.add(3);
		list1.add(5);
		list1.add(7);
		list1.add(1);
		System.out.println(isPalindrome(list1));
		
		System.out.println("original list=");
		System.out.print(" "+list2);

	}
	public static boolean isPalindrome(LinkedList<Integer> list)	{
		LinkedList<Integer>.Node<Integer> ptr1x = list.head;
		LinkedList<Integer>.Node<Integer> ptr2x = ptr1x;
		LinkedList<Integer>.Node<Integer> joint = null;
		
		while(ptr2x != null && ptr2x.next != null)	{
			joint = ptr1x;
			ptr1x = ptr1x.next;
			ptr2x = ptr2x.next.next;
			
		}
		
		System.out.println();
		LinkedList<Integer>.Node<Integer> left = list.head;
		LinkedList<Integer>.Node<Integer> right = ptr1x;
		if(ptr2x == null ) {
			right = ptr1x;
		} else {
			right = ptr1x.next;
		}
		LinkedList<Integer>.Node<Integer> pre = null;
		LinkedList<Integer>.Node<Integer> temp = null;
		while(right != null)	{
			temp = right.next;
			right.next = pre;
			pre = right;
			right = temp;
		}
		right = pre;
		boolean isPalindrome = true;
		while(right != null && left != ptr1x)	{
			System.out.println(right.data+","+left.data);
			if(right.data != left.data) {
				isPalindrome = false;
				break;
			}
			right = right.next;
			left = left.next;
		}
		
		right = pre;
		pre = null;
		while(right != null)	{
			temp = right.next;
			right.next = pre;
			pre = right;
			right = temp;
		}
		if(ptr2x == null) {
			joint.next = pre;
		} else 
		ptr1x.next = pre;
		
		return isPalindrome;
	}

}
