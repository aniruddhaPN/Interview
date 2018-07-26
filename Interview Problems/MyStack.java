import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    // Push element x onto stack.
	Queue q=new ArrayDeque();
	Queue q1=new ArrayDeque();
	
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	Queue temp;
    	int x =-1;
        if(q.isEmpty())
        	System.out.println("empty q");
        else
        {
        	while(!q.isEmpty())
        	{
         x=(Integer) q.remove();
        	if(!q.isEmpty())
        	{
        		q1.add(x);
        	}
        	}
        	temp=q;
        	q=q1;
        	q1=temp;
        	System.out.println("the top"+x);
        	
        }
    }

    // Get the top element.
    public int top() {
    	Queue temp;
    	int x =-1;
        if(q.isEmpty())
        	return -1;
        	else
        {
        	while(!q.isEmpty())
        	{
        	x=(Integer) q.remove(); 	
        	q1.add(x);
        	}
        	temp=q;
        	q=q1;
        	q1=temp;
        	return x;        	
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(q.isEmpty())
        	return true;
        else
        	return false;
    }
}