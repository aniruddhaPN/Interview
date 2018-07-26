package BinaryTree;
/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * Leetcode-Solution Accepted
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if(root==null)
        return true;
	    return isSymmetric(root.left,root.right);
	    }
	    
	    public boolean isSymmetric(TreeNode t1,TreeNode t2)
	    {
	    	if(t1==null&&t2==null)
	    		return true;
	    	if(t1==null&&t2!=null||t1!=null&&t2==null||t1.val!=t2.val)
	    	    return false;
	    	return isSymmetric(t1.left,t2.right)&&isSymmetric(t1.right,t2.left);
	    }
	    
	public static void main(String args[])
	{
				TreeNode B=new TreeNode(12,
						new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
						new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
				TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(111));	
				SymmetricTree t=new SymmetricTree();
				System.out.println(t.isSymmetric(C));
	}
}

