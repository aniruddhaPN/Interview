package BinaryTree;


public class InvertBinaryTree {
	
public static TreeNode invertTree(TreeNode root) 
{
        if(root!=null)
        {
        	TreeNode temp = root.left;
        	root.left=root.right;
        	root.right=temp;
        	invertTree(root.left);
        	invertTree(root.right);
        }
        return root;
    }

public static void printInorder(TreeNode root)
{
	if(root==null)
		return;
	printInorder(root.left);
	System.out.print(root.val+" ");
	printInorder(root.right);
}

public static void main(String args[])
{
			TreeNode B=new TreeNode(12,
					new TreeNode(13,new TreeNode(14, new TreeNode(114), new TreeNode(342)),new TreeNode(16)),
					new TreeNode(20, new TreeNode(111), new TreeNode(1234)));
			TreeNode C=new TreeNode(20, new TreeNode(111), new TreeNode(1234));	
	printInorder(invertTree(B));
	printInorder(invertTree(C));

}

}
