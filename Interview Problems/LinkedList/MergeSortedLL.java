package LinkedList;

public class MergeSortedLL {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null&&l2!=null) return l2;
		if(l1!=null&&l2==null) return l1;
		if(l1==null&&l2==null) return null;
		ListNode head=null,current=null;
		while(l1!=null&&l2!=null)
		{
			if(l1.val<l2.val)
			{
				if(head==null)
				{
					head=l1;
					current=head;
				}
				else
				{
					current.next=l1;
					current=l1;
					l1=l1.next;				
				}
			}
			else
			{
				if(head==null)
				{
					head=l2;
					current=head;
				}
				else
				{
					current.next=l2;
					current=l2;
					l2=l2.next;
					
				}
			}
			System.out.println(current.val);
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
		ListNode L1=new ListNode(1,new ListNode(3,
				new ListNode(9,new ListNode(14,
						new ListNode(15,new ListNode(16,null))))));
		ListNode L2=new ListNode(2,new ListNode(4,
				new ListNode(5,new ListNode(6,
						new ListNode(7,new ListNode(8,null))))));
		printList(mergeTwoLists(L1,L2));
	}
}
