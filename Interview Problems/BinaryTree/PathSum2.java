package BinaryTree;

import java.util.*;


public class PathSum2 {
	static List<List<Integer>> biglist=new ArrayList<List<Integer>>();
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		pathSum(root,new ArrayList<Integer>(),sum);
		return biglist;

	}

	public static  void pathSum(TreeNode root,List<Integer> l,int sum)
	{
		//System.out.println(l1.toString());
		if(root!=null)
		{
			List<Integer> l1=new ArrayList<Integer>();
			l1.addAll(l);
			l1.add(root.val);	
			System.out.println(l1.toString()+ " "+sum);
			if(root.left==null&&root.right==null&&sum==root.val)
			{
//				System.out.println("i am added");
				biglist.add(l1);
			}
			else if(root.right!=null&& root.left==null)
			{
//				System.out.println("i am in right");
				pathSum(root.right,l1,sum-root.val);
			}
			else if(root.left!=null&&root.right==null)
			{
//			System.out.println("i am in left");
				pathSum(root.left,l1,sum-root.val);
			}
			else if(root.left!=null&&root.right!=null)
			{
//				System.out.println("i am in right left");
				pathSum(root.right,l1,sum-root.val);
				pathSum(root.left,l1,sum-root.val);
			}
		}
	

	}

	public static void main(String args[])
	{
		TreeNode B=new TreeNode(12,
				new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
		TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234));	

		System.out.println(pathSum(B,143).toString());
		//System.out.println(pathSum(C,131).toString());

	}
}
