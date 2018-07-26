package LinkedList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
	ListNode head=null;
	ListNode current=null;

	public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int cnt1=findLength(l1);
		int cnt2=findLength(l2);
		int carry=0;

		System.out.println("cnt1 "+cnt1+" cnt2 "+cnt2);

		if(cnt1==0&&cnt2!=0)    return l1;
		if(cnt2==0&&cnt1!=0)    return l2;
		if(cnt1==0&&cnt2==0)    return head;

		int diff1=Math.abs(cnt1-cnt2);

		//		if(cnt1>cnt2)
		//			copyUpto(l1,diff1);
		//		else if(cnt2>cnt1)
		//			copyUpto(l2,diff1);


		while(l1!=null&&l2!=null)
		{
			int value=l1.val+l2.val;
			int rem=value%10;
			int node_value=rem+carry;
			carry=value/10;

			if(head==null)
			{
				head=new ListNode(node_value);
				current=head;
				System.out.println("head node "+head.val);

			}
			else
			{
				ListNode temp=new ListNode(node_value);
				current.next=temp;
				current=current.next;
			}
			System.out.println("current node "+current.val);
			l1=l1.next;
			l2=l2.next;
		}
		return head;
	}

	public int findLength(ListNode l)
	{
		int cnt=0;
		while(l!=null)
		{
			cnt++;
			l=l.next;	
		}
		return cnt;
	}

	public static  void printLinkedList(ListNode l)
	{
		while(l!=null)
		{
			System.out.println("value---" +l.val);
			l=l.next;
		}
	}

	public static void main(String args[])
	{
		AddTwoNumbers a=new AddTwoNumbers();
		ListNode l1=new ListNode(0,new ListNode(4));
		ListNode l2=new ListNode(1,new ListNode(5));

	//	printLinkedList(a.addTwoNumbers(l1, l2));
		ListNode l3=new ListNode(0);	
		ListNode l4=new ListNode(0);

		printLinkedList(a.addTwoNumbers(l3, l4));
	}
}
//public ListNode copyUpto(ListNode l,int diff)
//{
//	while(l!=null)
//	{
//
//		if(head==null)
//		{
//
//			head=new ListNode(l.val);
//			current=head;
//		}
//		else
//		{
//			current.next=new ListNode(l.val);  
//		}
//		l=l.next;
//	}
//	return l;
//
//}

