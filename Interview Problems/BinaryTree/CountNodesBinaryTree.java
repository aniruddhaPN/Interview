package BinaryTree;


public class CountNodesBinaryTree {
	 public static int countTreeNodes(TreeNode root) {
		 if(root==null)
			 return 0;
		 else if(root.left==null&&root.right==null)
	    	 return 1;
	     else
	    	 return 1+countTreeNodes(root.left)+countTreeNodes(root.right);
	    }

	 public static void main(String args[])
	 {
	 TreeNode B=new TreeNode(12,
				new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
		TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234));	
		System.out.println(+countTreeNodes(B));
		System.out.println(+countTreeNodes(C));

		}
}
