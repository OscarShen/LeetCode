package longestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharacters2 {
	public int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}
		if (s.equals("")) {
			return 0;
		}
		int res = 0;
		int n = s.length();
		char[] chars = s.toCharArray();
		int i = 0, j = 0;
		boolean[] exist = new boolean[256];

		while (j < n) {
			if (exist[chars[j]]) {
				res = Math.max(res, j - i);
				while (chars[i] != chars[j]) {
					exist[chars[i]] = false;
					i++;
				}
				i++;
				j++;
			} else {
				exist[chars[j]] = true;
				j++;
			}
		}
		res = Math.max(res, n - i);
		return res;
	}
}
