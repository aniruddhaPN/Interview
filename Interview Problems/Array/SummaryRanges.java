package Array;

	public class SummaryRanges {
	    public List<String> summaryRanges(int[] nums) {
	        
	        List<String> lst=new ArrayList<String>();

	        if(nums.length==0)
	        return lst;
	        
	        if(nums.length==1)
	        {
	            lst.add(String.valueOf(nums[0]));
	            return lst;
	        }
	        
	        int start=nums[0];
	        int end=nums[nums.length-1];
	        int prev=nums[0];
	        for(int i=1;i<nums.length;i++)
	        {
	            if(nums[i]==prev+1)
	            {
	                prev=nums[i];
	                end=nums[i];
	            }
	            else if(i==nums.length-1)
	            {
	                lst.add(start+"->"+end);
	            }
	            else
	            {
	                lst.add(start+"->"+end);
	                start=nums[i];
	            }
	        }
	        return lst;
	    }
	}

