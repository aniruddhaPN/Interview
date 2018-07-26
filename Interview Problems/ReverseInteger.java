
public class ReverseInteger {
	public int reverse(int x) {
		boolean neg=false;
		long  sum=0;
		int no;
		if(x<0)
			neg=true;
		if(neg)
			x=Math.abs(x);
		while (x>0)
		{
			no =x%10;
			x=x/10;
			sum=sum*10+no;

			System.out.println(sum);
		}
		if(neg)
			sum= sum*-1;
		//System.out.println(""+Integer.MAX_VALUE);
		if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE)
			sum= 0;   
		return (int)sum;
	}
	public static void main(String args[])
	{
		ReverseInteger ri=new ReverseInteger();
		System.out.println(ri.reverse(1534236469));
		//System.out.println(ri.reverse(-12345678));

	}
}
