package String;

public class ParsingStrtoInt {
	/*
	 * Convert the String to integer -
	 * parseInt function in java implementation
	 */
	public static int parseTheStr(String s)
	{
		int sum=0;
		int len=s.length();
		for(int i=0;i<len;i++)
		{
			int x=s.charAt(i);
			sum+=Math.pow(10,len-(i+1))*(x-48);
		}
		return sum;
	}
	public static void main(String args[])
	{
	String s="1234";
	System.out.println(parseTheStr(s));
	}
}
