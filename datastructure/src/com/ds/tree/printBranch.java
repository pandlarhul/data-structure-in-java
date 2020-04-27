package com.ds.tree;

public class printBranch{
	
	public static printEachBranch(Node root) {
		System.out.println(root.data);
		while(root.left != null || root.right!= null) {
			if(root.left != null && root.right!= null) {
			  System.out.println(root.data);
			  printtwoBranch(root.left)
			  
			}
			if(root.left == null)
				System.out.println(root.data);
			    printoneBranch(root.right);
			}
		   if(root.right == null) {
			    System.out.println(root.data);
		        printoneBranch(root.left);
		}
		}
		
		return null;
	}

	

}
