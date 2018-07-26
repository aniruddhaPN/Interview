package String;
import java.util.HashMap;
import java.util.Hashtable;

public class IsoMorph {
	public static boolean isIsomorphic(String s, String t) {
	    
    	Hashtable<Character,Character> h1=new Hashtable<Character,Character>();

		if(s.equals(t))
			return true;
		for(int i=0;i<s.length();i++)
		{
			if(!h1.containsKey(s.charAt(i)))
			{
				if(h1.containsValue(t.charAt(i)))
					return false;
				else
					h1.put(s.charAt(i),t.charAt(i));
			}   
			else
			{
				if(h1.get(s.charAt(i))!=t.charAt(i))
					return false;
			}
	

		}
		return true;
		       }
          
	
	
	public static void main(String args[]) {
		System.out.println(isIsomorphic("abab", "baba"));
		System.out.println(isIsomorphic("aba", "baa"));
		System.out.println(isIsomorphic("aa", "bb"));
		System.out.println(isIsomorphic("ab", "bb"));
	}
}
