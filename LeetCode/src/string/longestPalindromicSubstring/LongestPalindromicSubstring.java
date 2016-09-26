package string.longestPalindromicSubstring;

import org.junit.Test;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int maxLength = 0, startPos = 0, tempLength = 0;
		int n = s.length();

		for (int i = 0; i < n; ++i) {
			// 以单个字符s[i]为中心
			int left = i, right = i;
			while (left - 1 >= 0 && right + 1 < n && s.charAt(left - 1) == s.charAt(right + 1)) {
				--left;
				++right;
			}
			tempLength = right - left + 1;
			if (tempLength > maxLength) {
				maxLength = tempLength;
				startPos = left;
			}

			// 以s[i]和s[i+1]为中心
			if (i + 1 >= n || s.charAt(i) != s.charAt(i + 1))
				continue;
			left = i;
			right = i + 1;
			while (left - 1 >= 0 && right + 1 < n && s.charAt(left - 1) == s.charAt(right + 1)) {
				--left;
				++right;
			}
			tempLength = right - left + 1;
			if (tempLength > maxLength) {
				maxLength = tempLength;
				startPos = left;
			}
		}
		return s.substring(startPos, startPos + maxLength);
	}

	@Test
	public void test() {
		System.out.println(longestPalindrome("a"));
	}
}
