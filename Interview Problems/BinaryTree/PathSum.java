package BinaryTree;

public class PathSum {

	/* returns the maximum path sum*/
	public static int calculateSum(TreeNode root)
	{
		if(root==null)
			return 0;

		else
			return Math.max(root.val+calculateSum(root.left) ,root.val+calculateSum(root.right));		
	}

	/* Check whether if there exists a path sum*/
	public static boolean hasPathSum(TreeNode root,int sum)
	{
		if(root==null)
			return false;
		if(root.left==null&&root.right==null)
			return (sum==root.val);
		else
		{
			sum=sum-root.val;
//			if(root.left==null&&root.right!=null)
//				return hasPathSum(root.right,sum) || (sum==0);
//			else if(root.right==null&&root.left!=null)
//				return hasPathSum(root.left,sum) ||  sum==0;
//			else
				return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);

		}
	}
	public static void main(String args[])
	{
		TreeNode B=new TreeNode(12,
				new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
		TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234));	
		TreeNode D=new TreeNode(20, new TreeNode(900), new TreeNode(1234));	
		TreeNode E=new TreeNode(1,new TreeNode(2),null);

		System.out.println(	hasPathSum(B,22));
		System.out.println(hasPathSum(C,131));
		System.out.println(hasPathSum(D,920));
		System.out.println(hasPathSum(E,1));



	}
}
