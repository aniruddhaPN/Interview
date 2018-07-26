package BinaryTree;

public class SortedArrayToBST {
	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums==null)
			return null;
		if(nums.length==1)
			return new TreeNode(nums[0]);
		return sortedArrayToBST(nums,0,nums.length-1);
	}

	public static TreeNode sortedArrayToBST(int a[],int start,int end)
	{
		int mid=(start+end)/2;
		TreeNode root=null;
		if(start>end)
		{
			return null;
		}
		root=new TreeNode(a[mid]);
		System.out.println("processing "+a[mid]);
		root.left=sortedArrayToBST(a,0,mid-1);
		root.left=sortedArrayToBST(a,mid+1,end);

		return root;
	}

	public static void printinorder(TreeNode root)
	{
		if(root!=null)
		{
			printinorder(root.left);
			System.out.println(root.val);
			printinorder(root.right);
		}
	}

	public static void main(String args[])
	{
		int nums[]={1,2,3,4,5,6};
		printinorder(sortedArrayToBST(nums));
	}

}

