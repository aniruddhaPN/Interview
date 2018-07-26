package String;

public class CombinationsOfString {

	public static void combinations(String str,String prefix)
	{
		int n=str.length();
		System.out.println(prefix);
		for(int i=0;i<n;i++)
		{
			String end=str.substring(i+1,n);
			combinations(end,prefix+str.charAt(i));
		}
	}
	
	
	public static void main(String args[])
	{
		String s="abc";
		combinations(s,"");
	}
}
