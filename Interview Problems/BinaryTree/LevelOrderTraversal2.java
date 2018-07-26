package BinaryTree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal2 {
	/**
	 * Definition for binary tree public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> biglist = new ArrayList<List<Integer>>();
		if(root==null)
			return biglist;

		Queue<TreeNode> curr_q= new ArrayDeque<TreeNode>();
		curr_q.add(root);
		List<Integer> smal_list=new ArrayList<Integer>();
		smal_list.add(root.val);
		biglist.add(smal_list);
		smal_list=new ArrayList<Integer>();	
		Queue<TreeNode> next_q = new ArrayDeque<TreeNode>();

		while(!curr_q.isEmpty())
		{
			TreeNode ext_node=curr_q.remove();
//			System.out.println("big_list "+biglist.toString());	
//			System.out.println("smal_list "+smal_list.toString());		
//			System.out.println("extnode "+ext_node.val);		

			if(ext_node.left!=null)
			{
				smal_list.add(ext_node.left.val);
				next_q.add(ext_node.left);
			}
			if(ext_node.right!=null)
			{
				smal_list.add(ext_node.right.val);
				next_q.add(ext_node.right);
			}

			if(curr_q.isEmpty())
			{
				if(next_q.isEmpty())
					return biglist;
				if(smal_list.isEmpty())
					return biglist;
				
				biglist.add(smal_list);
				smal_list=new ArrayList<Integer>();
				curr_q=next_q;
				next_q = new ArrayDeque<TreeNode>();
			}

		}
		return biglist;
	}

	public static void main(String args[])
	{
		LevelOrderTraversal2 trav=new LevelOrderTraversal2();
		TreeNode B=new TreeNode(12,
				new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(20, new TreeNode(111,new TreeNode(1),new TreeNode(2)), 
						new TreeNode(1234,new TreeNode(4),new TreeNode(6))));
		TreeNode C=new TreeNode(20, new TreeNode(111,new TreeNode(1),new TreeNode(2)), 
				new TreeNode(1234));	
		
		TreeNode D=new TreeNode(0,new TreeNode(2,new TreeNode(1,new TreeNode(5),new TreeNode(1)),null),
				new TreeNode(4,new TreeNode(3,null,new TreeNode(6)),
						new TreeNode(-1,null,new TreeNode(8))));	
		
//		System.out.println((trav.levelOrder(B)).toString());
//		System.out.println((trav.levelOrder(C)).toString());
		System.out.println((trav.levelOrder(D)).toString());

	}
}
