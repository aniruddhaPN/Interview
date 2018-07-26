package Array;

import java.util.Arrays;

public class RotateArray {
	public static void rotateArray(int a[],int order)
	{
		reverseArray(a,0,a.length-(order+1));
		//System.out.println(Arrays.toString(a));

		reverseArray(a,a.length-order,a.length-1);
		//System.out.println(Arrays.toString(a));

		reverseArray(a,0,a.length-1);
		System.out.println(Arrays.toString(a));

	}
	public static void reverseArray(int a[],int start,int end)
	{
		if(a.length==1||a==null)
			return;
		int j=end;int temp;
		for(int i=start;i<j;i++)
		{
			temp=a[j];
			a[j]=a[i];
			a[i]=temp;
			--j;
		}
	}
	public static void main(String args[])
	{
		int a[]={1,2,3,4,5,6};
		rotateArray(a,2);
		int b[]={1,2};
		rotateArray(b,1);
	}

}
