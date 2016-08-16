package string.longestCommonPrefix;

public class LongestCommonPrefix {// 这题太不够细心了！！！反复出问题
	public String longestCommonPrefix(String[] strs) {
		if (strs == null)
			return "";
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];

		String s = "";
		int length = Integer.MAX_VALUE;
		for (String str : strs) {
			if (str == null || str.equals(""))
				return "";
			if (str.charAt(0) != strs[0].charAt(0))
				return "";
			if (str.length() < length) {
				length = str.length();
				s = str;
			}
		}
		int len;
		for (len = 0; len < length; len++) {
			for (int i = 0; i < strs.length; i++) {
				if (strs[i].charAt(len) == s.charAt(len))
					continue;
				return s.substring(0, len);
			}
		}
		return s;
	}
}
