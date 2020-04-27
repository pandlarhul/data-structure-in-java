package com.ds.linkedlist;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GetMergePoint {
	public static void main(String[] args) {
		// solve2();
		findMergePointUsingArray();
	}

	public static void solve1() {
		Node n1 = new Node(10);
		Node head1 = n1;
		Node n2 = new Node(20);
		n1.next = n2;
		Node n3 = new Node(30);
		n2.next = n3;
		Node n4 = new Node(40);
		n3.next = n4;
		Node n5 = new Node(50);
		n4.next = n5;
		Node n6 = new Node(60);
		n5.next = n6;
		Node n7 = new Node(70);
		n6.next = n7;
		n7.next = null;

		Node n8 = new Node(80);
		Node head2 = n8;
		Node n9 = new Node(90);
		n8.next = n9;
		n9.next = n5;

		Node ptr1 = head1;
		Node ptr2 = head2;
		outer: while (ptr1 != null) {
			ptr2 = head2;
			while (ptr2 != null) {
				if (ptr1 == ptr2) {
					break outer;
				}
				ptr2 = ptr2.next;
			}
			ptr1 = ptr1.next;
		}
		System.out.println("first = " + ptr1.data);
		System.out.println("Second = " + ptr1.data);
	}

	public static void solve2() {
		Node n1 = new Node(10);
		Node head1 = n1;
		Node n2 = new Node(20);
		n1.next = n2;
		Node n3 = new Node(30);
		n2.next = n3;
		Node n4 = new Node(40);
		n3.next = n4;
		Node n5 = new Node(50);
		n4.next = n5;
		Node n6 = new Node(60);
		n5.next = n6;
		Node n7 = new Node(70);
		n6.next = n7;
		n7.next = null;

		Node n8 = new Node(80);
		Node head2 = n8;
		Node n9 = new Node(90);
		n8.next = n9;
		n9.next = n5;

		Node ptr1 = head1;
		Node ptr2 = head2;

		LinkedList<Node> stack1 = new LinkedList<Node>();
		LinkedList<Node> stack2 = new LinkedList<Node>();

		while (ptr1 != null) {
			stack1.push(ptr1);
			ptr1 = ptr1.next;
		}

		while (ptr2 != null) {
			stack2.push(ptr2);
			ptr2 = ptr2.next;
		}

		ptr1 = stack1.pop();
		ptr2 = stack2.pop();
		Node mergePoint = null;
		while (ptr1 == ptr2) {
			mergePoint = ptr1;
			System.out.println("ptr1 = " + ptr1.data);
			System.out.println("ptr2 = " + ptr2.data);
			ptr1 = stack1.pop();
			ptr2 = stack2.pop();
		}
		System.out.println(mergePoint.data);

	}

	public static void findMergePointUsingArray()	{
		Node n1 = new Node(10);
		Node head1 = n1;
		Node n2 = new Node(20);
		n1.next = n2;
		Node n3 = new Node(30);
		n2.next = n3;
		Node n4 = new Node(40);
		n3.next = n4;
		Node n5 = new Node(50);
		n4.next = n5;
		Node n6 = new Node(60);
		n5.next = n6;
		Node n7 = new Node(70);
		n6.next = n7;
		n7.next = null;
		
		
		Node n8 = new Node(80);
		Node head2 = n8;
		Node n9 = new Node(90);
		n8.next = n9;
		n9.next = n5;
		
		Node ptr1 = head1;
		Node ptr2 = head2;
		int length1 = 0;
		int length2 = 0;
		int difference = 0;
		
		
		
		
		
		while(ptr1!= null || ptr2 != null)	{
			
			if(ptr1 != null && ptr2 != null) {
				length1 = length2 = length1 + 1;
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
			}
			else if(ptr2 != null) {
				length2 += 1;
				ptr2 = ptr2.next;
			}else {
				length1 += 1;
				ptr1 = ptr1.next;
			}
		}
		Node smallList = null;
		Node largeList = null;
		
		Node array[] = new Node[length1 + length2];
		difference = Math.abs(length2 - length1);
		int index = 0;
		if(length1 > length2) {
			smallList = head2;
			largeList = head1;
		} else {
			largeList = head1;
			smallList = head2;
		}
		
		while(smallList != null || largeList != null)	{
			if(smallList != null && largeList != null) {
				array[index++] = smallList;
				array[index++] = largeList;
				smallList = smallList.next;
				largeList = largeList.next;
			}  else {
				array[index++] = largeList;
				largeList = largeList.next;
				}
		}
		System.out.println("difference="+difference);
		System.out.println("array element =");
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].data);
		}
		
		System.out.println("end array element");
		//System.out.println("l1 = "+length1+" l2 = "+length2);
outer:		for (int i = 0; i < array.length; i++) {
			if((i+(2*difference+1)) < array.length)
			for (int j = 1; j <= 2*difference+1; j+=2) {
				if(array[i] == array[i+j]) {
					System.out.println("merge point = "+array[i].data);
					break outer;
				}
			}
			System.out.print(array[i].data+" ");			
		}

		

	}
}
