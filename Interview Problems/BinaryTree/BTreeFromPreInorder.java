package BinaryTree;

/*
 * Construct Binary Tree from Preorder and Inorder Traversal
 * Leetcode-Accepted
 */
/*
 *  * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BTreeFromPreInorder{
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(inorder.length==0||preorder.length==0)
			return null;

		return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

	}

	public TreeNode buildTree(int [] preorder,int pre_start,int pre_end
			,int [] inorder,int in_start,int in_end)
	{
		if(in_start>in_end||pre_start>pre_end)
			return null;

		int root_value=preorder[pre_start];

		TreeNode root=new TreeNode(root_value);

		if(in_start==in_end)
			return root;

		int index=0;
		for(int i=in_start;i<=in_end;i++)
		{
			if(root_value==inorder[i])
			{
				index=i;
				break;
			}
		}
		root.left=buildTree(preorder,
				pre_start+1 ,   pre_start+index-in_start,
				inorder, 
				in_start, index-1);
		root.right=buildTree(preorder,
				pre_start+index-in_start+1 ,    pre_end,
				inorder,
				index+1, in_end);

		return root;
	}
}