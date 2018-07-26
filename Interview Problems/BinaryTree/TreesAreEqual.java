package BinaryTree;


public class TreesAreEqual {

	public static boolean isEqual(TreeNode root1,TreeNode root2)
	{
		if(root1==null&&root2!=null)
			return false;
		else if(root1!=null&&root1==null)
			return false;
		else if(root1==null&&root2==null)
			return true;
		else if(root1.val==root2.val)
		{
			return isEqual(root1.left,root2.left)&&isEqual(root1.right,root2.right);
		}
		else
			return false;
	}
	public static void main(String args[])
	{
		TreeNode B=new TreeNode(12,
				new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
		TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234));	
		TreeNode D=new TreeNode(12,
				new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
		TreeNode E=new TreeNode(20, new TreeNode(111), new TreeNode(1234));	
		
		System.out.println(isEqual(B,C));		
		System.out.println(isEqual(D,C));
		System.out.println(isEqual(C,E));
		System.out.println(isEqual(B,D));
	}
}
