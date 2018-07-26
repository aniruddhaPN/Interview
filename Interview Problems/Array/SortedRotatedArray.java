package Array;

public class SortedRotatedArray {
	
	public static boolean searchElement(int array1[],int element,int start,int end)
	{
		int pivot=(start+end)/2;
//		System.out.println("loopstarts"+start+"--"+pivot+"--"+end);
		if(element==array1[pivot])
			return true;
		else if(array1[start]<array1[end])
		{
//			System.out.println("loop0");

			return binarySearch(array1,element,start,end);
		}
		else if(array1[start]<array1[pivot])
		{
//			System.out.println("loop1");
			if(element>=array1[start]&&element<=array1[pivot])
			{
//				System.out.println("loop1 if");
				return binarySearch(array1,element,start,pivot);
			}
			else
			{
//				System.out.println("loop1 else");
				searchElement(array1,element,pivot+1,end);
			}
		}
		else if(array1[pivot+1]<array1[end])
		{
//			System.out.println("loop2");

			if(element>=array1[pivot+1]&&element<=array1[end])
			{
			binarySearch(array1,element,pivot+1,end);
			}
			else
			{
				searchElement(array1,element,start,pivot);
			}
		}
		return false;
	}

	private static boolean binarySearch(int[] array1, int element, int low,
			int high) 
	{
//		System.out.println("in binary search");
		int mid=(high+low)/2;
		if(element==array1[mid])
			return true;
		else if(high==low)
			return false;
		else if(element<array1[mid])
			return binarySearch(array1,element,low,mid);
		else if(element>array1[mid])
			return binarySearch(array1,element,mid+1,high);
		else
			return false;	
	}

	public static void main(String args[])
	{
		int a[]={7,9,10,14,1,3,5};
		int b[]={2,4,6,8,9,0,1};
		int c[]={4,5,6,7,0,1,2};
		System.out.println(searchElement(a,6,0,a.length-1));
		System.out.println(searchElement(b,6,0,b.length-1));
		System.out.println(searchElement(c,5,0,c.length-1));
		System.out.println(searchElement(c,9,0,c.length-1));


	}
}
