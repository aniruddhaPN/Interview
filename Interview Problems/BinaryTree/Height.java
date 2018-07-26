package BinaryTree;


public class Height {
	/*
	 * Height of a binary treef
	 */
	public static int height(TreeNode root)
	{
		if(root==null)
			return 0;
		else
		return 1+Math.max(height(root.left),height(root.right));
	}
	
	public static void main(String args[])
	{
		TreeNode B=new TreeNode(12,
				new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
		TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234));		
		System.out.println(height(B));
		System.out.println(height(C));
	}
}
