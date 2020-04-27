package com.ds.linkedlist;

import java.util.HashMap;

public class LinkedList<T>{
	Node<T> head;
	@SuppressWarnings("hiding")
	class Node<T>{
		T data;
		Node<T> next;
		public Node(T data)	{
			this.data = data;
		}
	}
	
	HashMap<Integer,Node<T>> hashTable = new HashMap<Integer,Node<T>>();
	int lastIndex = -1;
	
	public LinkedList()	{
		head = null;
	}
	
	public void push(T data)	{
		Node<T> newData = new Node<T>(data);
		if(head == null) {
			head = newData;
		} else {
				newData.next = head;
				head = newData;
			}
	}
	
	public T pop()	{
		if(head == null) {
			return null;
		} else {
			T getdata = (T) head.data;
			head = head.next;
			return getdata;
		}
	}
	
	public void add(T newData)	{
		Node<T> newNode = new Node<T>(newData);
		if(head == null) {
			head = newNode;
			hashTable.put(0, newNode);
		} else {
			Node<T> ptr = head;
			while(ptr.next != null)	{
				ptr = ptr.next;
			}
			ptr.next = newNode;
		  }
	}
	
	
	
	public T peek()	{
		if(head == null)
			return null;
		else 
			return (T) head.data;
	}
	
// problem 2	
	public T findAtPosFromEnd(int pos) throws Exception	{
		
		Node<T> ptr = null;
		
		if(head == null) {
			throw new Exception("List is empty");
		} else {
			int size = size();
			if(size <= pos ||  pos < 0) {
				return null;
			} else {
				ptr = head;
				int cur = 0;
				pos = (size-1) - pos;
					while(cur != pos)	{
						ptr = ptr.next;
						cur ++ ;
					}
						
					}
		 }
		return (T) ptr.data;
	}

	
	// problem 3	
		public T findAtPosFromEndUsingHash(int pos) throws Exception	{
			if(head == null) {
				throw new Exception("List is empty");
			} else {
				int size = size();
				System.out.println(size);
				if(size <= pos ||  pos < 0) {
					return null;
				} else {
					pos = (size-pos)-1;	
				  }
			 }
			return (T) (hashTable.get(pos)).data;
		}

	
	
	public int size()	{
		if(head == null) {
			return 0;
		}
		int size = 0;
		Node<T> ptr = head;
		while(ptr!= null) {
			size ++ ;
			ptr = ptr.next;
		}
		return size;
	}
	
	
	public void show() throws Exception	{
		if(head == null) {
			throw new Exception("List is Empty Exception");
		} else {
			Node<T> ptr = hashTable.get(0);
			while(ptr != null)	{
				System.out.println(ptr.data);
				ptr = ptr.next;
			}
		}
	}
	
	public void addUsingHashMap(T newData)	{
		
			Node<T> newNode = new Node<T>(newData);
			if(head == null) {
				head = newNode;
				lastIndex += 1;
				hashTable.put(lastIndex, newNode);
				
			} else {
				Node<T> ptr = hashTable.get(lastIndex);
				ptr.next = newNode;
				lastIndex += 1;
				hashTable.put(lastIndex, newNode);
			  }
			
	}
	
	
	public T get(int i)	{
		if(head == null) {
			return null;
		}else {
			return hashTable.get(i).data;
		}
		
	}
	
	@Override
	public String toString() {
		Node ptr = hashTable.get(0);
		while(ptr != null)	{
			System.out.println(" "+ptr.data);
			ptr = ptr.next;
		}
		return "";
	}
}
