package com.ds.linkedlist;

public class PrintCommonElement {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		list1.add(50);
		list1.add(60);

		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(9);
		list2.add(15);
		list2.add(16);
		list2.add(20);
		list2.add(45);
		list2.add(46);
		list2.add(60);
		list2.add(70);
		
		LinkedList<Integer> result;
		try {
			result = printCommonElement(list1, list2);
			result.show();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static LinkedList<Integer> printCommonElement(LinkedList<Integer> l1, LinkedList<Integer> l2) throws Exception {
		LinkedList<Integer>.Node<Integer> ptr1 = l1.head;
		LinkedList<Integer>.Node<Integer> ptr2 = l2.head;
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		while (ptr1 != null && ptr2 != null) {
			
			if (ptr1.data < ptr2.data) {
				ptr1 = ptr1.next;
			} else if (ptr1.data > ptr2.data) {
				ptr2 = ptr2.next;
			} else {
				
				list.addUsingHashMap(ptr1.data);
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
				
			}
		}
		
	
		return list;
	}
	

}
