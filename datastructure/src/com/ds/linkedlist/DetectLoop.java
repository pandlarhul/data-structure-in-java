package com.ds.linkedlist;




public class DetectLoop {

	
	public static void main(String[] args) throws InterruptedException {	
		
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
		
		Node slow = head;
		Node fast = head;
		boolean isCycle = false;
		
		while(fast != null && slow!= null && fast.next != null)	{
			System.out.println("slow="+slow.data + "  fast="+fast.data);
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				isCycle = true;
				break;
			}
		}
		int count = 1;
		System.out.println("after detecting");
		if(isCycle == true) {
			fast = fast.next ;
			while(slow != fast) {
				count ++;
			fast = fast.next;
			}
			
		}
		System.out.println(count);
//		while(ptr != null)	{
//			System.out.print(" "+ptr.data);
//			ptr = ptr.next;
//		}
		
		
		int insertData = 4;
		Node ptr1 = head.next;
		Node pre = head;
		while(ptr1 != null && ptr1.data < insertData)	{
			pre = ptr1;
			ptr1 = ptr1.next;
		}
		Node newData = new Node(insertData);
		pre.next = newData;
		newData.next = ptr1;
		
		ptr1 = head;
		while(ptr1 != null)	{
			System.out.print(ptr1.data+" ");
			ptr1 = ptr1.next;
		}
		
		
	}

}
