package BinaryTree;
/*
 * Leetcode -Accepted - Construct Binary Tree from post order and Inorder traversal
 */
public class BTreeFromInPostOrder {
	public  TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length==0||postorder.length==0)
			return null;
		if(inorder.length==1||postorder.length==1)
			return new TreeNode(inorder[0]);

		return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
	}
	public TreeNode buildTree(int[] inorder, int i_start,int i_end,int[] postorder,
			int p_start,int p_end)
	{

		int index=0;

		if(i_start>i_end||p_start>p_end)
			return null;

		int root_value=postorder[p_end];

		for(int i=i_start;i<=i_end;i++)
		{
			if(inorder[i]==root_value)
			{index= i;
			break;}

		}

		TreeNode root=new TreeNode(root_value);
		if(i_start==i_end)
			return root;
		root.left=buildTree(inorder,i_start,index-1,postorder,p_start,(index-1-i_start)+p_start);
		root.right=buildTree(inorder,index+1,i_end,postorder,(index-i_start)+p_start,p_end-1);

		return root;
	}


	public static void printInorder(TreeNode root)
	{
		if(root==null)
			return;
		printInorder(root.left);
		System.out.println(root.val);
		printInorder(root.right);

	}
	public static void main(String args[])
	{
		BTreeFromInPostOrder b=new BTreeFromInPostOrder();
		int inorder[]={4,2,5,1,6,3,7};
		int postorder[]={4,5,2,6,7,3,1};
		int inorder1[]={2,3,1};
		int postorder1[]={3,2,1};
		TreeNode t=b.buildTree( inorder,  postorder);
		printInorder(t);
		printInorder(b.buildTree(inorder1,postorder1));
	}
}
