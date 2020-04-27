package com.ds.linkedlist;

public class NodeWithRandom {
	 NodeWithRandom next;
	 NodeWithRandom random;
	 int data;
	 public NodeWithRandom(int data, NodeWithRandom random)	{
		 this.random = random;
		 this.data = data;
	 }
	 
	 public NodeWithRandom(int data) {
		 this.data = data;
	 }
	 

}
