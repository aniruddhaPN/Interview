package String;

import java.util.StringTokenizer;

public class LengthOfLastWord {

	//    public static int lengthOfLastWord(String s) {
	//        StringTokenizer st=new StringTokenizer(s);
	//        String newst=null;
	//        while(st.hasMoreTokens())
	//        {
	//             newst=st.nextToken();
	//        }
	//        
	//        return newst.length();
	//    }

	//    public static int lengthOfLastWord(String s) {
	//    	int len=0;
	//    	if(s==null)
	//    		return 0;
	//    	char arr[]=s.toCharArray();
	//    	for(int i=0;i<arr.length;i++)
	//    	{
	//    		if(arr[i]==' ')
	//    			len=0;
	//    		else
	//    			len++;
	//    	}    
	//        return len;
	//    }
	//    
	public static int lengthOfLastWord(String s) {
		int len=0;
		if(s==null)
			return 0;
		char arr[]=s.toCharArray();
		boolean flag=true;
		for(int i=arr.length-1;i>=0;i--)
		{
//			if(flag)
//				{
				if(arr[i]==' '&&len>0)
					return len;
				
			else
			{
				if(arr[i]!=' ')
				++len;
			}
	//			}
			System.out.println("length "+len+" arr "+arr[i]);
		
//			if(arr[i]==' '&&flag==false)
//				flag=true;

		}    
		return len;
	}
	public static void main(String args[])
	{
		System.out.println(lengthOfLastWord("Hello wor"));
	}
}