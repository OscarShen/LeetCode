package string.generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	List<String> res = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		if (n <= 0)
			return new ArrayList<>();
		String str = "(";
		solve(n, 1, str);
		return res;
	}

	private void solve(int n, int leftNum, String str) {
		if (str.length() == n * 2) {
			res.add(str);
			return;
		}
		leftLessThanN(n, leftNum, str);
		rightLessThanLeft(n, leftNum, str);
	}

	private void leftLessThanN(int n, int leftNum, String str) {
		if (leftNum < n) {
			str += '(';
			leftNum++;
			solve(n, leftNum, str);
		}
	}

	private void rightLessThanLeft(int n, int leftNum, String str) {
		if (leftNum > str.length() - leftNum) {
			str += ')';
			solve(n, leftNum, str);
		}
	}
}
