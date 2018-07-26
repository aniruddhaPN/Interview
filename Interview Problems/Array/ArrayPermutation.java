package Array;


public class ArrayPermutation {
	public static void permuteArray(int nums[],int res1[])
	{
		if(nums.length==1)
		{
			System.out.print(nums[0]);
			System.out.println();
			return;
		}
		for(int i=0;i<nums.length;i++)
		{
			System.out.print(nums[i]);
			int result[]=new int[nums.length-1];
			System.arraycopy(nums,0,result,0,i);
			System.arraycopy(nums,i+1,result,i,nums.length-(i+1));
			permuteArray(result,res1);
		}
	}


	public static void main(String args[])
	{
		int b[]={1,2,3};
		int a[]={3,2,1};
		int c[]={1,1,5};
		int d[]={1,2};
		ArrayPermutation ap=new ArrayPermutation();
		ap.permuteArray(b, new int[b.length]);
		ap.permuteArray(b);
		System.out.println();
	}
}
