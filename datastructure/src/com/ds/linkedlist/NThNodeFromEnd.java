package com.ds.linkedlist;

public class NThNodeFromEnd {
	public static void main(String[] args) {
		long start = 0;
		long end = 0;
		start = System.currentTimeMillis();
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addUsingHashMap(11);
		list.addUsingHashMap(22);
		list.addUsingHashMap(33);
		list.addUsingHashMap(44);
		list.addUsingHashMap(55);
		int positionFromEnd = 1;
		
		try {
			
			System.out.println(positionFromEnd+" position from end="+list.findAtPosFromEndUsingHash(positionFromEnd));
			list.show();
			end = System.currentTimeMillis();
			System.out.println("Elapsed time = "+(end-start));
			
		} catch (Exception e) {
			System.out.println(e.getMessage()+" Exception");
			e.printStackTrace();
		}
//		System.out.println(i);
		
	}

}
