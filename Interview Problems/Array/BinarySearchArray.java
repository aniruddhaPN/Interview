package Array;

public class BinarySearchArray {
	/*
	 * Search for an element in a sorted array
	 * Using binary search ,split the array into two halves and start the search
	 * return true if element found
	 * return false if not
	 */

	private static boolean searchElement(int[] a, int key, int start, int end) {
		int mid=(start+end)/2;
		if(a[mid]==key)
			return true;
		else if(start==end)
			return false;
		else if(a[mid]>key)
			 return searchElement(a,key,start,mid);
		else if(a[mid]<key)
			return searchElement(a,key,mid+1,end);
		return false;
		
	}
	public static void main(String args[])
	{
		int a[]={7,9,10,14,15,23,25};
		int b[]={2,4,6,8,9,10,11};
		int c[]={4,5,6,7,10,11,21};
		System.out.println(searchElement(a,6,0,a.length-1));
		System.out.println(searchElement(a,25,0,a.length-1));
		System.out.println(searchElement(b,6,0,b.length-1));
		System.out.println(searchElement(c,5,0,c.length-1));

	}

	
}
