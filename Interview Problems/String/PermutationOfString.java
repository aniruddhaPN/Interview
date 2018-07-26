package String;

public class PermutationOfString {
/*
 * given a string permute the string
 */
	public static void permuteString(String str,String prefix)
	{
		if(str.length()==0)
			System.out.println(prefix);
		int len=str.length();
		for(int i=0;i<len;i++)
		{
			String begin=str.substring(0,i);
			String end=str.substring(i+1,len);
			permuteString(begin+end,prefix+str.charAt(i));
		}
	}

	public static void main(String args[])
	{
		String s="red";
		permuteString(s,"");
	}
}
