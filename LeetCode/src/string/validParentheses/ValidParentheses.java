package string.validParentheses;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.equals(""))
			return true;
		Stack<Character> stack = new Stack<>();

		char[] chars = s.toCharArray();

		int n = chars.length;
		for (int i = 0; i < n; i++) {
			switch (chars[i]) {
			case ('('):
				stack.push('(');
				break;
			case ('['):
				stack.push('[');
				break;
			case ('{'):
				stack.push('{');
				break;
			case (')'):
				if (stack.isEmpty() || stack.pop() != '(')
					return false;
				break;
			case (']'):
				if (stack.isEmpty() || stack.pop() != '[')
					return false;
				break;
			case ('}'):
				if (stack.isEmpty() || stack.pop() != '{')
					return false;
				break;
			default:
				break;
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}
}
