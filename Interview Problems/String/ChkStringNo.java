package String;

public class ChkStringNo {
	/*
	 * Check whether a given string is a no 
	 */

	public static boolean chkIfNumber(String s)
	{
		char arr1[]=s.toCharArray();
		int j=0;
		if(arr1[0]=='.')
			j++;
		if(arr1[0]=='-')
		{
			j++;
			if(arr1[1]=='.')
				j++;
		}
		
		for( int i=j;i<arr1.length;i++)
		{
			int no=arr1[i];
			//System.out.println(no);
			
			if(!(no>=48&&no<=57))
				return false;
		}
		return true;
	}
	
	public static void main(String args[])
	{
		System.out.println(chkIfNumber("12344s"));
		System.out.println(chkIfNumber("12344"));
		System.out.println(chkIfNumber("a12344"));
		System.out.println(chkIfNumber(".12344"));
		System.out.println(chkIfNumber("-12344"));
		System.out.println(chkIfNumber("-123-44"));
		System.out.println(chkIfNumber("-.123-44"));
		System.out.println(chkIfNumber("-.12344"));





	}
}
