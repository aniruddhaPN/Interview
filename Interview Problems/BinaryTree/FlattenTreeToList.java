package BinaryTree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
 * Given a binary tree, flatten it to a linked list in-place.
 * Leetcode -solution -Accepted
 */
public class FlattenTreeToList {
    public void flatten(TreeNode root) {
        if(root==null)
			return;
		if(root.left==null&&root.right==null)
		    return;
		
		flatten(root.left);
		flatten(root.right);
		
		if(root.left!=null)
		{
	    	TreeNode temp=root.left;
		    root.left=null;
		    
		    TreeNode temp1=root.right;
		    root.right=temp;
		    
		    while (temp.right != null) {
		        temp = temp.right;
		    }
		    temp.right=temp1;
		}
		
    }
}