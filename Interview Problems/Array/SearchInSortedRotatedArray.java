package Array;

public class SearchInSortedRotatedArray {
	    public int search(int[] nums, int target) {
	         return binarySearch (nums,0,nums.length-1,target);
	    }
	    
	    public int binarySearch(int[] nums,int start,int end,int target)
	    {
	        if(start>end)
	        return -1;
	        
	        if(start==end)
	        {
	            if(nums[start]==target)
	            return start;
	        }
	        if(nums[start]<nums[end] &&(target<nums[start]||target>nums[end]))
	               return -1;
	               
	        int middle_index=(start+end)/2;
	        
	        if(nums[middle_index]==target)
	        return middle_index;
	        
	        return Math.max(binarySearch(nums,start,middle_index-1,target), binarySearch(nums,middle_index+1,end,target));
	   
	    }
	}

