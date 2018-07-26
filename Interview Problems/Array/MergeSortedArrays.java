package Array;

public class MergeSortedArrays {

	public static int[] merge(int a[],int b[])
	{
		int c[]=new int[a.length+b.length];
		int i=0,j=0,k=0;
		while(i<a.length&&j<b.length)
		{
			if(a[i]<b[j])
				c[k]=a[i++];
			else
				c[k]=b[j++];
			k++;

		}
		while(i<a.length)
		{
			c[k]=a[i++];
			k++;
		}
		while(j<b.length)
		{
			c[k]=b[j];
			j++;
			k++;
		}
		return c;
	}

	public static void main(String args[])
	{
		int a[]={1,3,5};
		int b[]={2,4,6,8,9};
		int res[]=merge(a,b);
		for(int i=0;i<res.length;i++)
		{
			System.out.println(res[i]);
		}
	}
}
