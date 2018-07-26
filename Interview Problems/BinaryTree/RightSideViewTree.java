package BinaryTree;

/*
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Leetcode -solution Accepted
 */
import java.util.ArrayList;
import java.util.List;

public class RightSideViewTree {
	    	 List<Integer> l1=new ArrayList<Integer>();
	    	    
	    	    public List<Integer> rightSideView(TreeNode root) {
	    		    findChild(root,0);
	    		    return l1;
	    		    }
	    		    
	    		    public void findChild(TreeNode root,int level)
	    		    {
	    		        if(root==null)
	    		        return;
	    		        
	    		        if(level==l1.size())
	    		        l1.add(root.val);
	    		        
	    		        findChild(root.right,level+1);
	    		        findChild(root.left,level+1);
	    		    }
		        
		    
	    public static void main(String args[])
		{
			TreeNode B=new TreeNode(12,
					new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
					new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
			TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234,null,new TreeNode(1)));	
			TreeNode D=new TreeNode(20, null, new TreeNode(1234));	
			TreeNode E=new TreeNode(1,new TreeNode(2),null);
			RightSideViewTree b=new RightSideViewTree();

			System.out.println(b.rightSideView(B).toString());
			System.out.println(b.rightSideView(C).toString());
			System.out.println(b.rightSideView(D).toString());
			System.out.println(b.rightSideView(E).toString());
		}
	}

