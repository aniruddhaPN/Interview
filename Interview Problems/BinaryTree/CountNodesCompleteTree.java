package BinaryTree;

public class CountNodesCompleteTree {

	
	 public static void main(String args[])
	 {
	 TreeNode B=new TreeNode(12,
				new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
		TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234));	
		System.out.println(+countTreeNodes(B));
		System.out.println(+countTreeNodes(C));

		}

	private static int countTreeNodes(TreeNode b) {
		// TODO Auto-generated method stub
		return 0;
	}
}


