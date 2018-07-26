package BinaryTree;

import java.util.Stack;

/*
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.


 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    TreeNode root,current;
    Stack<TreeNode> node_stack=new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        this.root=root;
        if(root!=null)
        addtoStack(root);

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return !node_stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        current=node_stack.pop();
        int val=current.val;
        
        if(current.right!=null)
			addtoStack(current.right);
            
        return val;
    }
    
    public void addtoStack(TreeNode node)
	{
		while(node!=null)
		    {
		        node_stack.push(node);
    			node=node.left;
		    }

	}


/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

	public static void main(String args[])
	{
		TreeNode root=new TreeNode(1);
		BSTIterator i=new BSTIterator(root);
		System.out.println(i.hasNext());
		System.out.println(i.next());

	}
}
