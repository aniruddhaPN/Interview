package BinaryTree;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	TreeNode parent;
	
	public void AddLeft(TreeNode l) {
		this.left = l;
		this.left.parent = this;
	}
	
	public void AddRight(TreeNode r) {
		this.right = r;
		this.right.parent = this;
	}
	
	public void AddChildren(TreeNode l, TreeNode r) {
		AddLeft(l);
		AddRight(r);
	}
//	public String toString() {
//		String outp = "[" + this.left + "," + this.right + " ^" + this.parent + "]";
//		return outp;
//	}
	public TreeNode(int data,TreeNode left,TreeNode right)
	{
		this.val=data;
		this.left=left;
		this.right=right;
	}
	
	public TreeNode(int data)
	{
		this.val=data;
	}
	
	public static boolean findTreeNode(TreeNode root, TreeNode searchTreeNode)
	{
		if(searchTreeNode.val==root.val)
			return true;
		else if(root==null)
			return false;
		else
			return findTreeNode(root.left,searchTreeNode) || findTreeNode(root.right,searchTreeNode);					
	}
	
	public static void main(String args[])
	{
		TreeNode B=new TreeNode(12,
				new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
		TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234));	
		System.out.println(findTreeNode(B,new TreeNode(12)));
		System.out.println(findTreeNode(B,new TreeNode(100)));

	}

}

