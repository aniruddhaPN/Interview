package LinkedList;

import java.util.LinkedList;


public class FlattenBTreeToLL {
	static ListNode head=null;
	static ListNode current=null;
	static LinkedList<Integer> l=new LinkedList<Integer>();

	public static LinkedList<Integer> flattenTree(Node root)
	{
		if(root!=null)
		{			
		flattenTree(root.left);
		l.add(root.data);
		flattenTree(root.right);
		}		
		return l;
	}
	public static void flattenTree1(Node root)
	{
		if(root==null)
			return;
		flattenTree1(root.left);
		if(root.left!=null&&root.right==null)
			root.right=root.left;
		else if(root.left!=null&&root.right!=null)
		{
		root.left.right=root.right;
		root.right=root.left;		
		System.out.println("processibg root " +root.data+" the right node  "+root.right.data +
				" the right of right " +root.right.right.data);
		}
	}
	public static void printLinkedList(LinkedList<Integer> l)
	{		
			System.out.println(l.toString());
			System.out.println(l.size());

	}
	public static void main(String args[])
	{
	Node B=new Node(12,
			new Node(13,new Node(14, new Node(114), new Node(342)),new Node(16)),
			new Node(20, new Node(111), new Node(1234)));
	Node C=new Node(20, new Node(111), new Node(1234));	
	Node D=new Node(1,new Node(2,new Node(3),new Node(4)),new Node(5,null,new Node(6)));
	printLinkedList(flattenTree(C));
	printLinkedList(flattenTree(B));
	flattenTree1(D);
	printTree(D);


}
	private static void printTree(Node d) {
		// TODO Auto-generated method stub
		while(d!=null)
		{
			System.out.println(d.data);
			d=d.right;
		}
	}
}
