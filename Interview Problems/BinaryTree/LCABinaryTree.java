package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;

public class LCABinaryTree {

	public static void printarray(ArrayList<TreeNode> n ) {
		for (TreeNode x : n) {
			System.out.println("[" + x.val + "]");
		}
		System.out.println();
	}

	public static TreeNode commonAncestor(TreeNode root, TreeNode p1, TreeNode p2) {
		System.out.println(+p1.val + "---" + p2.val);

		ArrayList<TreeNode> parents1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> parents2 = new ArrayList<TreeNode>();

		TreeNode parent1 = p1.parent;
		while (parent1 != null) {
			parents1.add(parent1);
			parent1 = parent1.parent;
		}

		TreeNode parent2 = p2.parent;
		while (parent2 != null) {
			parents2.add(parent2);
			parent2 = parent2.parent;
		}

		Collections.reverse(parents1);
		Collections.reverse(parents2);

		printarray(parents1);
		System.out.println(parents1.get(0).val);
		printarray(parents2);

//		for (TreeNode par1 : parents1) {
//			for (TreeNode par2 : parents2) {
//				if (par1 == par2) return par2;
//			}
//		}
		TreeNode lastmatched = null;
		for(int i=0;i<parents1.size()&&i<parents2.size();i++)
		{
			if(parents1.get(i)==parents2.get(i))
			{
				 lastmatched=parents1.get(i);
			}
			else
				return lastmatched;
		}
		

		System.out.println("Default returning root ");
		return lastmatched;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(12);
		TreeNode l1 = new TreeNode(33);
		TreeNode r1 = new TreeNode(44);

		root.AddChildren(l1, r1);
		TreeNode l2 = new TreeNode(3);


		l1.AddLeft(l2);
		//l2.AddRight(r2);


		TreeNode r3 = new TreeNode(1023);
		TreeNode r4 = new TreeNode(4096);
		r3.AddLeft(r4);
		TreeNode r2 = new TreeNode(43);

		r1.AddLeft(r3);
		r1.AddRight(r2);

		TreeNode common = commonAncestor(root, r2, r3);
		System.out.println(common.val);
	}
}
