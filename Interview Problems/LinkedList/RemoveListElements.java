package LinkedList;

public class RemoveListElements {
	public static ListNode removeElements(ListNode head, int val) {
		ListNode prev=head, current=head;
		boolean sethead=true;
		head=null;
		if(current==null)
			return null;
		while(current!=null)
		{		
			if(current.val==val)
				prev.next=current.next;
			else
			{
				if(sethead)
				{
					head =current;
					sethead=false;
				}
				prev=current;
			}
			current=current.next;	
		}
		return head;
	} 

	public static void printList(ListNode head)
	{
		ListNode current=head;
		while(current!=null)
		{
			System.out.println(current.val);
			current=current.next;
		}
	}

	public static void main(String args[])
	{
		ListNode LL=new ListNode(1,new ListNode(2,
				new ListNode(3,new ListNode(4,
						new ListNode(5,new ListNode(6,null))))));
		ListNode newhead= removeElements(LL,2);
		ListNode L2=new ListNode(1,new ListNode(1,null));
		printList(newhead);	
		printList(removeElements(L2,1));		 

	}
}
