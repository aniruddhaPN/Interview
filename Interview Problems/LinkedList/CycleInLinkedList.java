package LinkedList;


public class CycleInLinkedList {
	/*
	 * find a loop in the linkedlist
	 * @return true - if loop exists
	 * @return fals - if loop doesnt exist
	 */
	public static boolean findCycle(ListNode node)
	{
		ListNode ptr1=node,ptr2=node;
		while(ptr1!=null &&ptr2!=null)
		{
			ptr1=ptr1.next;
			if(ptr2.next!=null)
				ptr2=ptr2.next.next;
			if(ptr1==ptr2)
				return true;
		}
		return false;
	}
	public static void main(String args[])
	{
		ListNode LL=new ListNode(1,new ListNode(2,
				new ListNode(3,new ListNode(4,
						new ListNode(5,new ListNode(6,null))))));
		System.out.println(findCycle(LL));
	}
}
