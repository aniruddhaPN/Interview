package BinaryTree;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Level order traversal of a binary tree
 */
public class LevelOrderTraverse {
	public static void levelOrder(TreeNode root)
	{
		Deque<TreeNode> q=new ArrayDeque<TreeNode>();
		if(root!=null)
		{
		q.add(root);
		}
		while(!q.isEmpty())
		{
			TreeNode current=q.remove();
			System.out.println(current.val);
			if(current.left!=null)
			q.add(current.left);
			if(current.right!=null)
			q.add(current.right);
		}				
	}
	
	public static void main(String args[])
	{
		TreeNode B=new TreeNode(12,
				new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
		TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234));		
		levelOrder(B);
		levelOrder(C);
	}
}
