package hashtable.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}
		if (s.equals("")) {
			return 0;
		}
		Set<Character> set = new HashSet<>();

		char[] chars = s.toCharArray();
		int n = chars.length;
		int res = 0;
		int begin = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			if (set.contains(chars[i])) {
				String str = s.substring(0, i);
				int t = str.lastIndexOf(chars[i]) + 1;
				begin = t > begin ? t : begin++;
				end++;
			} else {
				set.add(chars[i]);
				end++;
			}
			res = Math.max(res, end - begin);
		}
		return res;
	}
}
