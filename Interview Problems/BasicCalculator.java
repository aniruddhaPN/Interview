import java.util.Stack;

/*
 * "1 + 1" = 2
 " 2-1 + 2 " = 3
 "(1+(4+5+2)-3)+(6+8)" = 23
 */

public class BasicCalculator {
	public int calculate(String s) {
		String newstring=s.replaceAll(" ","");
		char array1[] = newstring.toCharArray();
		
		Stack<Integer> operandstack = new Stack<Integer>();
		Stack<Character> operatorstack = new Stack<Character>();
		int len = array1.length;
		int i = 0;
		int element;
		while (i < len) {
			if(array1[i]>='0'&&array1[i]<='9')
			{
				operandstack.push(Character.getNumericValue(array1[i]));
				i++;
			}
			else if(array1[i]==')')
			{
				element=operandstack.pop();
				while(element!=')'&&!operandstack.isEmpty())
				{
					
				}
			}
			else
			{
				operatorstack.push(array1[i]);
				i++;
			}
		}
			switch (array1[i]) {
			case '+': {
				int x = operandstack.pop();
				int y = Character.getNumericValue(array1[++i]);
				operandstack.push(x + y);
				System.out.println("peek in + ---->" + operandstack.peek());
				i++;
				break;
			}
			case '-': {
				int x = operandstack.pop();
				int y = Character.getNumericValue(array1[++i]);
				operandstack.push(x - y);
				System.out.println("peek in - ---->" + operandstack.peek());
				i++;
				break;
			}
			case '*': {
				int x = operandstack.pop();
				int y = Character.getNumericValue(array1[++i]);
				operandstack.push(x - y);
				System.out.println("peek in *" + operandstack.peek());
				i++;
				break;
			}
			case '/': {
				int x = operandstack.pop();
				int y = Character.getNumericValue(array1[++i]);
				operandstack.push(x - y);
				i++;
				break;
			}
			default: {
				int x = Character.getNumericValue(array1[i]);
				System.out.println("pushing x--" + x);
				operandstack.push(x);
				i++;
				break;
			}
			
			System.out.println("i am broke");
		}
		return operandstack.pop();
	}

	public static void main(String args[]) {
		BasicCalculator c = new BasicCalculator();
		System.out.println("final cal value====" + c.calculate("1+2-1*8/9"));
	}
}
