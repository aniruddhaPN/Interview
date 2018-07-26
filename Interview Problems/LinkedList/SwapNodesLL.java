package LinkedList;

public class SwapNodesLL {
	
	public static void swapNodes(ListNode head)
	{
		ListNode ptr1=head,ptr2=head;
		if(head==null||head.next==null)
			return;
		ptr2=head.next;
		while(ptr1!=null)
		{
		swap(ptr1,ptr2);
		ptr1=ptr2.next;
		if(ptr2.next==null)
			ptr2=null;
		else
		ptr2=ptr2.next.next;
		}
		
	}
	public static void swapNodes1(ListNode head)
	{
	}
	public static void swap(ListNode ptr1,ListNode ptr2)
	{
		int temp=ptr1.val;
		ptr1.val=ptr2.val;
		ptr2.val=temp;
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
		swapNodes1(LL);
		printListNode(LL);
	}
}
