
public class PowerFunction {
	/* 
	 * return a^b 
	 * Implementation of pow function
	 */

	public static double pow(double base,double exp)
	{
		double result=base;
		if(exp==0||exp==1)
		{
			return exp==0?1:result;
		}
		else if(exp>=2)
		{
			for(int i=2;i<=exp;i++)
			{
				result=result*base;
			}
			return result;
		}
		else if(exp<0)
		{
			return 1/pow(base,exp*-1);
		}
		return result;
	}
	public static void main (String args[])
	{
		System.out.println(pow(1,0));
		System.out.println(pow(2,2));
		System.out.println(pow(3,3));
		System.out.println(pow(3.3,3));
		System.out.println(pow(3,-1));
		System.out.println(pow(3,-2));
	}

}
