
public class PalindromeInteger {

	public static boolean isPalindrome(int number)
	{
		int div=1;
		while(number/div>9)
			div=div*10;
		//System.out.println(div);
		while(number!=0)
		{
			System.out.println(number + "  "+div);
			int p1=number/div;
			int p2=number%10;
			//System.out.println(" p1 "+p1+" p2 " +p2);
			if(p1!=p2)
				return false;
			number=(number-(p1*div))/10;
			div=div/100;
		}
		return true;
	}
	
	public static void main(String args[])
	{
		System.out.println(isPalindrome(12321));
//		System.out.println(isPalindrome(1001));
//		System.out.println(isPalindrome(1000021));

	}
}
