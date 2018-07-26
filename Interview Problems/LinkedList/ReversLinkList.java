package LinkedList;

public class ReversLinkList {
	public static ListNode reverseList(ListNode head)
	{
		ListNode current=null,prev=null,third=null;
		 if(head==null)
		        return null;
		        else if(head.next==null)
		        return head;
		current=head.next;
		third=current.next;
		head.next=null;
		current.next=head;
		prev=current;
		current=third;
		while(current!=null)
		{
			System.out.println("processing current"+current.val);
			third=current.next;
			current.next=prev;
			prev=current;
			System.out.println("what is next"+current.next.val);
			current=third;
		}	
		return prev;		
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
		printListNode(reverseList(LL));
	}
}
