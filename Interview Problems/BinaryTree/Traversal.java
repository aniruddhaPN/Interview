package BinaryTree;


public class Traversal {
	/*
	 *  in-order: left, root, right
	 *  pre-order: root, left, right
	 *  post-order: left, right, root
	 */
	 
	public static void preorder(TreeNode root)
	{
		if(root!=null)
		{
			System.out.println(root.val);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void inorder(TreeNode root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.println(root.val);
			inorder(root.right);
		}
	}
	
	public static void postorder(TreeNode root)
	{
		if(root!=null)
		{
			inorder(root.left);
			inorder(root.right);
			System.out.println(root.val);
		}
	}
	
	public static void main(String args[])
	{
		TreeNode B=new TreeNode(12,
				new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
		TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234));
		preorder(C);
		System.out.println("----");
		inorder(C);
		System.out.println("----");
		postorder(C);
		}

}