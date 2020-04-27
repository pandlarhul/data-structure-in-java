package com.ds.linkedlist;

public class NodeWithRandomPractice {
	public static void main(String[] args) {
		NodeWithRandom n1 = new NodeWithRandom(11);
		NodeWithRandom n2 = new NodeWithRandom(22);
		NodeWithRandom n3 = new NodeWithRandom(33);
		NodeWithRandom n4 = new NodeWithRandom(44);
		NodeWithRandom n5 = new NodeWithRandom(55);
		NodeWithRandom n6 = new NodeWithRandom(66);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		n1.random = n5;
		n2.random = n4;
		n3.random = n6;
		n5.random = n2;
		n6.random = n1;
		n4.random = n3;
		
		NodeWithRandom head = n1;
		show(head); 
				
	}
	public static void show(NodeWithRandom head)	{
		NodeWithRandom ptr = head;
		while(ptr.next != null)	{
			System.out.println(ptr.data +" next="+ptr.next.data+" random="+ptr.random.data);
			ptr = ptr.next;
		}
	}
	
	public static NodeWithRandom clone(NodeWithRandom head)	{
		NodeWithRandom ptr = head;
		NodeWithRandom cloneNode = head;
		ptr = 
		while(ptr != null) {
			cloneNode.next = ptr; 
		}
	}

}
