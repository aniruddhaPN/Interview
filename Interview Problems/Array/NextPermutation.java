package Array;
import java.util.Arrays;

/*
 * Here are some examples. Inputs are in the left-hand column
 *  and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class NextPermutation {

	public  void nextPermutation(int nums[])
	{
		int result[]=new int[nums.length];
		System.arraycopy(nums,0,result,0,nums.length);
		int index=binarySearch(nums,result[0]);
		
		for(int i=index;i<=index+1;i++)
		{
			System.out.println(index);
			int res1[]=new int[nums.length-1];
			System.arraycopy(nums,1,res1,0,nums.length-1);
			nextPermutation(res1);
		}	
	}
	
	public static int binarySearch(int src[],int res)
	{
		for(int i=0;i<src.length;i++)
		{
			if(res==src[i])
				return i;
		}
		return -1;
	}

	public static void main(String args[])
	{
		NextPermutation np=new NextPermutation();
		//int b[]={1,2,3};
		int a[]={3,2,1};
		int c[]={1,1,5};
		int d[]={1,2};	
		np.nextPermutation1(c);
		System.out.println();
//		np.nextPermutation(a);
//		System.out.println();
//		//3,2,1 -> 1,2,3
//		np.nextPermutation(c);
//		np.nextPermutation(d);
	}
	
	public void nextPermutation1(int nums[])
	{
		int len=nums.length;
		int index=1,count=1;
		int original[] = new int[len];
		for(int i=0;i<len;i++)
		{
			original[i]=nums[i];
		}
		if(len==2)
		{
		    if(nums[0]<nums[1])
		    {
		        int temp=nums[0];
		        nums[0]=nums[1];
		        nums[1]=temp;
		    }
		}
		while(count<len)
		{
			index=count;
			int max=nums[count],maxindex=index;
			for(int i=index;i<len;i++)
			{
				if(nums[index]>max)
				{
					max=nums[index];
					maxindex=index;

				}
				index++;
			}
			int temp=nums[count];
			nums[count]=nums[maxindex];
			nums[maxindex]=temp;
			count++;
		}
		for(int i=0;i<nums.length;i++)
		{
			System.out.print(nums[i]);
		}
		System.out.println(Arrays.equals(original,nums));		
		if(Arrays.equals(original,nums))
		{
			Arrays.sort(nums);
		}
		
		
	}
}
