package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * check if a string is of a few valid parentheses.
 *  e.g., "()([]{()})" is valid, while "()))" not.  
 */
public class ValidParanthesis {
	Stack<Character> tokstack;
	Map<Character, Character> hset;

	ValidParanthesis() {
		hset = new HashMap<Character, Character>();
		hset.put('}', '{');
		hset.put(']', '[');
		hset.put(')', '(');
		tokstack = new Stack<Character>();
	}

	private boolean evaluate(String str) {
		char array1[] = str.toCharArray();

		for (char c : array1) {
			// If not close bracket, push to stack.
			if (!hset.containsKey(c)) {
				tokstack.push(c);
			} else {

				if (tokstack.isEmpty())
					return false;

				char expected = hset.get(c);
				char actual = tokstack.pop();
				if (expected != actual) {
					return false;
				}
			}
		}
		if (!tokstack.isEmpty()) {
			return false;
		}

		return true;
	}

	public static void main(String args[]) {
		String str = "()([]{()})";
		String str1 = "()))";
		String str2 = "((({{}})))";
		String test1 = "()";
		String test2 = "({({()})})";
		String test3 = "(((((((";
		String test4 = ")))))(((((";
		String test5 = "))))))";

		ValidParanthesis v = new ValidParanthesis();

		System.out.println(v.evaluate(str));
		System.out.println(v.evaluate(str2));
		System.out.println(v.evaluate(test1));
		System.out.println(v.evaluate(test2));

		System.out.println(v.evaluate(test3));
		System.out.println(v.evaluate(test4));
		System.out.println(v.evaluate(test5));
		System.out.println(v.evaluate(str1));

	}
}
