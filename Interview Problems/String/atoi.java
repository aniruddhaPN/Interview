package String;

public class atoi {
	    public static int myAtoi(String str) {
	        char arr[]=str.toCharArray();
	        int num=0;
	        for(int i=0;i<arr.length;i++)
	        {
	            if(arr[i]>=48&&arr[i]<=57)
	            {
	                int c=arr[i];

	                num=num*10+(c-48);
	            	System.out.println(num);

	            }
	        }
			return num;
	    }
public static void main(String args[])
{
	System.out.println(myAtoi("0124"));
}
	    }
