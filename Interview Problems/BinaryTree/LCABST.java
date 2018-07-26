package BinaryTree;

public class LCABST {
	private static TreeNode findParent(TreeNode root, TreeNode p1,TreeNode p2) {
		if(p1.val<p2.val)
		{
			TreeNode ancestor=p1.parent;
			while(ancestor!=null)
			{
			if(ancestor.val>p1.val&&ancestor.val<p2.val)
				return ancestor;
			ancestor=p1.parent.parent;
			}
		}
		
		return null;
	}
	public static void printInorder(TreeNode root)
	{
		if(root!=null)
		{
			printInorder(root.left);
			System.out.print(root.val+"--");
			printInorder(root.right);
		}
	}
	public static void main(String args[])
	{
		TreeNode D=new TreeNode(20);	
		TreeNode l1=new TreeNode(11);
		TreeNode r1=new TreeNode(1234);
		TreeNode l2=new TreeNode(2);
		TreeNode r2=new TreeNode(13);
		D.AddChildren(l1,r1);
		l1.AddChildren(l2,r2);
		
		TreeNode E=new TreeNode(12,
				new TreeNode(11,new TreeNode(9, new TreeNode(8), new TreeNode(342)),new TreeNode(16)),
				new TreeNode(114, new TreeNode(111), new TreeNode(1234)));
		TreeNode F=new TreeNode(8,new TreeNode(3),new TreeNode(10));
		TreeNode L=new TreeNode(8,new TreeNode(3,new TreeNode(1),new TreeNode(6)),
				new TreeNode(10,null,new TreeNode(14,new TreeNode(13),null)));
		printInorder(D);
		System.out.println("  "+findParent(D,l2,r2).val);

	}	
}
