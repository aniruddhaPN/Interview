package LinkedList;

public class ReverseBetween {
	public static ListNode reverseBetw(ListNode head, int m, int n) {

		ListNode p1=gotoPos(m,head);
		int middle=(m+n)/2;
		while(m!=middle)
		{
			ListNode p2=gotoPos(n,head);
			swap(p1,p2);
			p1=p1.next;
			m=m+1;
		} 	
		return head;
	}

	private static void swap(ListNode p1, ListNode p2) {
		int temp=p1.val;
		p1.val=p2.val;
		p2.val=temp;
	}

	public static ListNode gotoPos(int pos,ListNode head)
	{
		int cnt=1;
		ListNode p1=head;
		while(cnt!=pos&&p1!=null)
		{
			p1=p1.next;
			cnt++;
		}
		return p1;
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
		ListNode L1=new ListNode(1,new ListNode(2,
				new ListNode(3,new ListNode(4,
						new ListNode(5,null)))));
		//printList(reverseBetw(LL,2,4));
		System.out.println(" ");
		//printList(reverseBetw(L1,2,5));
		ListNode L2=new ListNode(3,new ListNode(5,null));
		System.out.println(" ");
		printList(reverseBetw(L2,1,2));
	}
}

