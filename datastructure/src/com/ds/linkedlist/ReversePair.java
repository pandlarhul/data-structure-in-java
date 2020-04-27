package com.ds.linkedlist;

public class ReversePair {
	public static void main(String[] args) {
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
		Node n8 = new Node(80);
		n7.next = n8;
		n8.next = null;

		Node ptr = head1;
		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}

		ptr = head1;
		Node pre = null,current = head1,temp1 =null, temp2 =null;
		
		while (ptr != null && ptr.next != null  ) {
			
			temp1 = ptr.next.next;
			
			ptr.next.next = ptr;
			
			
			System.out.println("ptr.next"+ptr.next.data);

			if(pre == null) {
				 head1 = ptr.next;
				 pre = ptr;
			} else {
				pre.next = ptr.next;
				pre = ptr;
			}
			ptr.next = temp1;
			ptr = ptr.next;
			
			
			

//			Node temp = ptr.next.next;
//			ptr.next.next = ptr;
//			pre = ptr;
//			ptr = temp;
		}
		System.out.println("after");
		ptr = head1;
		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}

	}
	
}
