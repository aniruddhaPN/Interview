package BinaryTree;


public class BSTinsertion {

	/*
	 * Insert TreeNode to a binary search tree
	 */
	public static TreeNode insertTreeNode(TreeNode root,int element)
	{
		if(root!=null)
		{
			if(element<root.val)
			{
				//System.out.println("root.left="+root.left.data+","+element);
				root.left= insertTreeNode(root.left,element);
			}
			else if(element>root.val)
			{
				//System.out.println("root.right="+root.right.data+","+element);
				root.right=insertTreeNode(root.right,element);
			}
		}
		else
		{
			return new TreeNode(element);
		}
		return root;

	}

	public static void printInorder(TreeNode root)
	{
		if(root!=null)
		{
			printInorder(root.left);
			System.out.print(root.val+"--");
			printInorder(root.right);
		}

	}


	public static void main(String args[])
	{
		TreeNode D=new TreeNode(20, new TreeNode(11), new TreeNode(1234));	
		TreeNode E=new TreeNode(12,
				new TreeNode(11,new TreeNode(9, new TreeNode(8), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(114, new TreeNode(111), new TreeNode(1234)));
		TreeNode F=new TreeNode(8,new TreeNode(3),new TreeNode(10));
		TreeNode L=new TreeNode(8,new TreeNode(3,new TreeNode(1),new TreeNode(6)),new TreeNode(10,null,new TreeNode(14,new TreeNode(13),null)));
		printInorder(L);
		System.out.println();
		TreeNode G=insertTreeNode(L,15);
		printInorder(G);


	}

}
