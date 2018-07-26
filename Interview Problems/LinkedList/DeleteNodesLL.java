package LinkedList;


public class DeleteNodesLL {
	/*
	 * Delete alternate nodes in a LinkedList
	 */
	public static void deleteNode(ListNode node)
	{
		ListNode head=node;
		while(node!=null)
		{
			node.next=node.next.next;
			node=node.next;
		}
	}
	public static void printListNode(ListNode node)
	{
		while(node!=null)
		{
			System.out.print(node.val+"--");
			node=node.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		ListNode LL=new ListNode(1,new ListNode(2,
				new ListNode(3,new ListNode(4,
						new ListNode(5,new ListNode(6,null))))));
		printListNode(LL);
		deleteNode(LL);
		printListNode(LL);
	}
}
