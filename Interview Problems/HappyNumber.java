import java.util.HashSet;
import java.util.Set;


public class HappyNumber {
	static Set<Integer> s=new HashSet<Integer>();
	public static boolean isHappy(int n) {
		if(n==1)
        	return true;
        if(s.contains(n)) 
        	return false;
		s.add(n);        
        return isHappy(calculateSq(n));        
    }
	
	public static int calculateSq(int n)
	{
		int sum=0; int a=0;
		while(n>0)
        {
            a=n%10;
            System.out.println("a's value "+a);
            n=n/10;
            sum+=Math.pow(a,2);
        }
		return sum;
		
	}
	
	public static void main(String args[])
	{
		System.out.println(isHappy(12));
		System.out.println(isHappy(19));

	}
}
