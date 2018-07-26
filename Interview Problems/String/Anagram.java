package String;
import java.util.Arrays;
/*
 * check whether 2 strings are anagrams
 */

public class Anagram {
	public static boolean compare(String s1,String s2)
	{
		if(s1.length()!=s2.length())
			return false;			
		char arr1[]=s1.toCharArray();
		char arr2[]=s2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1,arr2);		
	}
	public static void main(String args[])
	{
		String s="hello";
		String t="madad";
		String r="elohl";
		System.out.println(compare(s,t));
		System.out.println(compare(s,r));		

	}

}
