package Array;
/*
 * Find Minimum in Rotated Sorted Array 
 * Leetcode - solution Accepted
 */

public class FindMinSortedRotatedArray {
	    public int findMin(int[] nums) {
	        return binarySearch(nums,0,nums.length-1);
	    }
	    
	public int binarySearch(int[] nums,int start,int end)
		    {
		        if(start==end)
		        return nums[start];
		        
		        if(nums[start]<nums[end])
		        return nums[start];

		               
		        int middle_index=(start+end)/2;
		        return Math.min(binarySearch(nums,start,middle_index), binarySearch(nums,middle_index+1,end));
		   
		    }
	    
	}
	
