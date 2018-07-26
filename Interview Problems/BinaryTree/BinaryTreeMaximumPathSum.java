package BinaryTree;

public class BinaryTreeMaximumPathSum {
	public static int maxPathSum(TreeNode root) {
		if(root==null)
			return 0;
		if(root.val<0)
			return Math.max(maxPathSum(root.left),maxPathSum(root.right))
					;
		
		return Math.max(
				Math.max(maxPathSum(root.left),maxPathSum(root.right)),
				Math.max(
				root.val,
				Math.max(root.val+maxPathSum(root.left),root.val+maxPathSum(root.right))
				)							
				)
				;
				
	}
	
		public static void main(String args[])
		{
			TreeNode B=new TreeNode(12,
					new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
					new TreeNode(20, new TreeNode(111,new TreeNode(1),new TreeNode(2)), 
							new TreeNode(1234,new TreeNode(4),new TreeNode(6))));
			TreeNode C=new TreeNode(20, new TreeNode(1,new TreeNode(-40),new TreeNode(-40)), 
					new TreeNode(-12));	

			TreeNode D=new TreeNode(0,new TreeNode(2,new TreeNode(1,new TreeNode(5),new TreeNode(1)),null),
					new TreeNode(4,new TreeNode(3,null,new TreeNode(6)),
							new TreeNode(-1,null,new TreeNode(8))));
			
			TreeNode E=new TreeNode(-2,new TreeNode(1),null);

			System.out.println(maxPathSum(E));

		}
	}
