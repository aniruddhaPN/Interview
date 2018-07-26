package Array;

import java.util.Random;

public class RandomPermutation {
	/*
	 * Generate random permutation of an array
	 */
	private static void permute(int[] a) {
		int len=a.length;
		if(len==0)
			return;
		Random rn =new Random();
		int rand_no=rn.nextInt(len);
		System.out.println("   "+a[rand_no]);
		int result[]=new int[a.length-1];
		for(int i=0;i<rand_no;i++)
		{
			result[i]=a[i];
		}
		for(int i=rand_no;i<len-1;i++)
		{
			result[i]=a[i+1];
		}
		permute(result);
	}	
	public static void main(String args[])
	{
		int a[]={1,2,3,4};
		permute(a);
	}
}
