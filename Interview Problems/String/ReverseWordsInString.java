package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
 */
public class ReverseWordsInString {
	 public String reverseWords(String s) {
		 if(s==null||s.length()==0)
		        return s;
		       
		      String arr1[]=s.split("\\s+");
		      StringBuilder sb=new StringBuilder();
		      int j=0;
		      for(int i=arr1.length-1;i>=0;i--)
		      {
		          if(sb.length()>0)
		            sb.append(" ");
		         sb.append(arr1[i].toString().trim());

		      }
		      
		      return sb.toString().trim();
	    }
	   
//	public void reverseWords(String s) {
//		StringTokenizer st=new StringTokenizer(s);
//		String arr[]=new String();

//		List<String> l=new ArrayList<String>();
//		int cnt=0;
//		while(st.hasMoreTokens())
//		{
//			l.add(st.nextToken());
//			System.out.println(st.nextToken());
//			cnt++;
//		}
//		Collections.reverse(l);
		
		
//
//	}
//
	public static void main(String args[])
	{
		ReverseWordsInString r=new ReverseWordsInString();
		System.out.println(r.reverseWords("the sky is blue"));
		System.out.println(r.reverseWords("a  b"));
		System.out.println(r.reverseWords("a b"));


	}

}
