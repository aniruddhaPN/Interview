package LinkedList;

import java.util.Stack;

public class PalindromeList {

	 public static boolean isPalindrome(ListNode head) {
		 Stack<Integer> chklist=new Stack<Integer>();
		 ListNode current=head;
		 while(current!=null)
		 {
			 chklist.push(current.val);
			 current=current.next;
		 }
		 current=head;
		 while(!chklist.isEmpty())
		 {
			 int element=chklist.pop();
			 System.out.println("comparing "+element+" "+current.val);
			 if(element!=current.val)
				 return false;
			 current=current.next;			 
		 }
		return true;
	        
	    }
	 
	 public static boolean isPalindrome1(ListNode head) {
		 Stack<Integer> chklist=new Stack<Integer>();
		 ListNode current=head;
		 while(current!=null)
		 {
			 chklist.push(current.val);
			 current=current.next;
		 }
		 current=head;
		 while(!chklist.isEmpty())
		 {
			 int element=chklist.pop();
			 System.out.println("comparing "+element+" "+current.val);
			 if(element!=current.val)
				 return false;
			 current=current.next;			 
		 }
		return true;
	        
	    }
	 public static void printList(ListNode head)
		{
			ListNode current=head;
			while(current!=null)
				System.out.println(current.val);
		}

		public static void main(String args[])
		{
			ListNode LL=new ListNode(1,new ListNode(2,
					new ListNode(3,new ListNode(3,
							new ListNode(2,new ListNode(1,null))))));
			ListNode L1=new ListNode(1,new ListNode(2,
					new ListNode(3,new ListNode(3,
							new ListNode(4,new ListNode(1,null))))));
			//printList(LL);		
			System.out.println(isPalindrome(LL));
			System.out.println(isPalindrome(L1));

		}
}
