package BinaryTree;


public class MirrorImageTree {

	public static TreeNode mirror(TreeNode root)
	{		
		if(root!=null)
		{			
				 TreeNode temp=root.right;
				 root.right=root.left;
				 root.left=temp;
				 mirror(root.left);
				 mirror(root.right);
				 return root;
		}
		return null;	
	}
	
	public static void printInorder(TreeNode root)
	{
		if(root==null)
			return;
		printInorder(root.left);
		System.out.print(root.val+" ");
		printInorder(root.right);

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
		printInorder(B);																		
		mirror(B);
		System.out.println();
		printInorder(B);
		System.out.println();
		printInorder(C);
		mirror(C);
		System.out.println();
		printInorder(C);
		mirror(D);
		mirror(E);

	}					
}
