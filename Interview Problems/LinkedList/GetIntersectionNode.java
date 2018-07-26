package LinkedList;

public class GetIntersectionNode {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		ListNode p1=headA,p2=headB;
		int cnt1=0,cnt2=0,start_pos1=0,start_pos2=0;

		cnt1=getCount(headA);
		cnt2=getCount(headB);
		if(cnt1>cnt2)
			start_pos1=cnt1-cnt2;
		else
			start_pos2=cnt2-cnt1;

		System.out.println("cnt1 "+cnt1+" cnt2 " +cnt2);

		p1=headA;p2=headB;
		for(int i=0;i<start_pos1;i++)
		{
			p1=p1.next;
		}
		for(int i=0;i<start_pos2;i++)
		{
			p2=p2.next;
		}

		while(p1!=null&&p2!=null)
		{
			System.out.println("p1 val"+p1.val+" p2 val "+p2.val);
			if(p1.val==p2.val)
				return p1;
			p1=p1.next;
			p2=p2.next;
		}
		return null;
	}

	public static int getCount(ListNode head)
	{
		ListNode p=head;
		int cnt=0;
		while(p!=null)
		{
			cnt++;
			p=p.next;
		}
		return cnt;
	}

	public static void main(String args[])
	{
		ListNode LL=new ListNode(1,new ListNode(2,
				new ListNode(3,new ListNode(4,
						new ListNode(5,new ListNode(6,null))))));
		ListNode L2=new ListNode(1,new ListNode(1,null));

		ListNode I1=new ListNode(3,null);
		ListNode I2=new ListNode(2,new ListNode(3,null));
		// System.out.println( getIntersectionNode( LL,  L2));
		System.out.println( getIntersectionNode( I1,  I2));

	}
}

