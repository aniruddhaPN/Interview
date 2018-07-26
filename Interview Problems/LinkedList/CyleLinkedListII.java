package LinkedList;

public class CyleLinkedListII {
	public static ListNode detectCycle(ListNode head) {
        ListNode slow_ptr=head,fast_ptr=head;
        ListNode current=head;
        if(head ==null||head.next==null)
        return null;
        while(fast_ptr!=null)
        {
            if(slow_ptr==fast_ptr)
                return slow_ptr;
            slow_ptr=slow_ptr.next;
            if(fast_ptr.next==null)
            fast_ptr=null;
            else
            fast_ptr=fast_ptr.next.next;
        }
       return null;
        
    }
	public static void main(String args[])
	{
		ListNode LL=new ListNode(1,new ListNode(2,
				new ListNode(3,new ListNode(4,
						new ListNode(5,new ListNode(6,null))))));
		System.out.println(detectCycle(LL).val);
	}
}
