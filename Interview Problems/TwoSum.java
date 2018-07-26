import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, 

You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */

public class TwoSum {
	public static int[] twoSum1(int[] nums, int target) 
	{
		/* 
		 * complexity o(n2)
		 */
		int[] array1 = new int[2];
		for(int i=0;i<nums.length;i++)
		{
			for(int j=i+1;j<nums.length;j++)
			{
				if((nums[i]+nums[j]) ==target)
				{
					array1[0]=i;
					array1[1]=j;
				}
			}
		}
		return array1;
	}
	
	public static int[] twoSum2(int[] nums, int target) 
	{
		/* 
		 * Time complexity o(n)
		 */
		
		int[] array1 = new int[2];
		Map<Integer,Integer> m1= new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++)
		{
			m1.put(nums[i],i);			
		}
	   
		for(int j=0;j<nums.length;j++)
		{
		int diffvalue=target-nums[j];
		if(m1.containsKey(diffvalue))
		{
			array1[0]=j;
			array1[1]=m1.get(diffvalue);
//			System.out.println("j value"+(j));
//			System.out.println("diffvalue "+array1[1]);
		}
		}

		return array1;
	}
	public static void main(String args[])
	{
		int arr[]={2,7,11,15};
		//System.out.println(Arrays.toString(twoSum(arr,9)));
		System.out.println(Arrays.toString(twoSum1(arr,17)));
		System.out.println(Arrays.toString(twoSum2(arr,17)));

	}
}
