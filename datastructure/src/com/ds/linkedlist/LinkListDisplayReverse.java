package com.ds.linkedlist;

public class LinkListDisplayReverse {
	public static void main(String[] args) {
		Node n1 = new Node(10);
		Node head = n1;
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
		Node n9 = new Node(90);
		n8.next = n9;
		n9.next = null;
		Node ptr = head;
		showReverse(ptr);
	}
	public static void showReverse(Node ptr)	{
		if(ptr.next != null) {
			showReverse(ptr.next);
		}
		System.out.print(" "+ptr.data);
	}

}
