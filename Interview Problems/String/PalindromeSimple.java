package String;

public class PalindromeSimple {

	/* 
	 * check whether a string is a palindrome or not
	 */
	public static boolean checkPalindrome(String s)
	{
		if(s.equals(new StringBuffer(s).reverse().toString()))
		{
			return true;
		}
		else
		{
			return false;
		}
//		StringBuilder build=new StringBuilder(s);
//		String rev=build.reverse().toString();
//		
//		if(s.equals(rev))
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}
	}
	public static void main(String args[])
	{
		System.out.println(checkPalindrome("madam"));
		System.out.println(checkPalindrome("hello"));
		System.out.println(checkPalindrome("twiiwt"));
	}
}
