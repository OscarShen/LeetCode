package stack.basicCaculator;

import java.util.Stack;

public class BasicCalculator {
	public static void main(String[] args) {
		String s = "1-1+1";
		System.out.println(s + "=" + new BasicCalculator().calculate2(s));
	}

	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int sign = 1;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int cur = c - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					cur = 10 * cur + s.charAt(++i) - '0';
				}
				res = sign * cur + res;
			} else if (c == '+') {
				sign = 1;
			} else if (c == '-') {
				sign = -1;
			} else if (c == '(') {
				stack.push(res);
				res = 0;
				stack.push(sign);
				sign = 1;
			} else if (c == ')') {
				res = stack.pop() * res + stack.pop();
				sign = 1;
			}
		}
		return res;
	}

	public int calculate2(String s) {
		Stack<Integer> stack = new Stack<>();
		int res = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int cur = c - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					cur = cur * 10 + s.charAt(++i) - '0';
				}
				stack.push(cur);
			} else if (c == '*') {
				while (s.charAt(i + 1) == ' ') {
					i++;
				}
				i++;
				int cur = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					cur = cur * 10 + s.charAt(++i) - '0';
				}
				int temp = stack.pop() * cur;
				stack.push(temp);
			} else if (c == '/') {
				while (s.charAt(i + 1) == ' ') {
					i++;
				}
				i++;
				int cur = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					cur = cur * 10 + s.charAt(++i) - '0';
				}
				int temp = stack.pop() / cur;
				stack.push(temp);
			} else if (c == '+') {
				stack.push(1);
			} else if (c == '-') {
				stack.push(-1);
			}
		}

		int[] nums = new int[stack.size()];
		int n = stack.size();
		for (int i = n - 1; i > -1; i--) {
			nums[i] = stack.pop();
		}
		res = nums[0];
		for (int j = 1; j < n - 1; j = j + 2) {
			res += nums[j] * nums[j + 1];
		}
		return res;
	}
}
