package Array;

	public class RemoveElement {
	    public int removeElement(int[] nums, int val) {
	        if(nums.length==0)
	        return 0;
	        int start=0;
	        int end=nums.length-1;
	        int size=nums.length;
	        int temp=0;
	        while(start<end)
	        {
	            while(nums[end]!=val)
	            {
	                end--;
	                size--;
	            }
	            if(nums[start]==val)
	            {
	                temp=nums[start];
	                nums[start]=nums[end];
	                nums[end]=temp;
	                size--;
	            }
	        }
	        return size;
	    }
	}

