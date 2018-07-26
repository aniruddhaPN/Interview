package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * Leetcode-solution -Accepted
 */
public class BTreeZigZagTraversal {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	 public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        Stack<TreeNode> curr_stack=new Stack<TreeNode>();
	        Stack<TreeNode> next_stack=new Stack<TreeNode>();
	        List<Integer> smal_list=new ArrayList<Integer>();
	        List<List<Integer>> big_list=new ArrayList<List<Integer>>();
	        
	        if(root==null)
	        return big_list;
	         
	        TreeNode element=null;
	        curr_stack.push(root);
	        int level=1;
	        while(!curr_stack.isEmpty())
	        {
	            element=curr_stack.pop();
	            smal_list.add(element.val);
	            if(level%2!=0)
	            {
	            if(element.left!=null)  next_stack.push(element.left);
	            if(element.right!=null) next_stack.push(element.right);
	            }
	            else
	            {
	            if(element.right!=null) next_stack.push(element.right);
	            if(element.left!=null)  next_stack.push(element.left);  
	            }
	            if(curr_stack.isEmpty())
	            {
	                big_list.add(smal_list);
	                smal_list=new ArrayList<Integer>();
	                curr_stack=next_stack;
	                next_stack=new Stack<TreeNode>();
	                level++;
	            }
	        }
	        
	        return big_list;
	    }
	    
	    
	    public static void main(String args[])
		{
			TreeNode B=new TreeNode(12,
					new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),
							new TreeNode(16)),
					new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
			
			TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234));	
			
			TreeNode D=new TreeNode(20, new TreeNode(11), new TreeNode(1234));	
			
			TreeNode E=new TreeNode(12,
					new TreeNode(11,new TreeNode(9, new TreeNode(8), new TreeNode(342)),
							new TreeNode(16)),
					new TreeNode(114, new TreeNode(111), new TreeNode(1234)));
			
			System.out.println(zigzagLevelOrder(B).toString());
			
			System.out.println(zigzagLevelOrder(C).toString());
			

		}		
	}

