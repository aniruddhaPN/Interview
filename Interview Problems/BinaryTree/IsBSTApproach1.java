package BinaryTree;


public class IsBSTApproach1 {
	/*
	 * Check whether binary tree is a binary search tree
	 */
	
	public static boolean isBinarySearchTree(TreeNode root)
	{
		if(root==null)
		{
			return true;
		}
		
		else if(root.left!=null&&root.right!=null)
		{
			if(root.left.val<root.val&&root.right.val>root.val)
			{
				return (isBinarySearchTree(root.left)&&isBinarySearchTree(root.right));
			}
			else
				return false;
		}
		else if(root.left==null&&root.right!=null)
		{
			if(root.right.val>root.val)
				return (isBinarySearchTree(root.right));
		}
		
		else if(root.right==null&&root.left!=null)
		{
			if(root.left.val>root.val)
				return (isBinarySearchTree(root.left));
		}
		else if(root.left==null&&root.right==null)
		{
			return true;
		}
		return false;
	}

	public static void main(String args[])
	{
		TreeNode B=new TreeNode(12,
				new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
		TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234));	
		TreeNode D=new TreeNode(20, new TreeNode(11), new TreeNode(1234));	
		TreeNode E=new TreeNode(12,
				new TreeNode(11,new TreeNode(9, new TreeNode(8), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(114, new TreeNode(111), new TreeNode(1234)));

		System.out.println(isBinarySearchTree(B));
		System.out.println(isBinarySearchTree(C));
		System.out.println(isBinarySearchTree(D));
		System.out.println(isBinarySearchTree(E));


	}
}
