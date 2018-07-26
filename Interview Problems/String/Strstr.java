package String;

	public class Strstr {
	    public static int strStr(String haystack, String needle) {
	        
	        int len=needle.length();
	        if(haystack.length()==0&&len==0)
	        return 0;
	        
	        for(int i=0;i<=haystack.length()-len;i++)
	        {
	        	System.out.println(haystack.substring(i,i+len));
	            if((haystack.substring(i,i+len)).equals(needle))
	            return i;
	        }
	        return -1;
	    }
	    
	    public static void main(String args[])
	    {
	    	String haystack="mississippi";
	    	String needle="pi";
	    	
	    	//System.out.println(strStr(haystack,needle));
	    	System.out.println(strStr("aaaa", "baaa"));

	    }
	}

