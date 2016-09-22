package string.implementStr;

public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || needle.length() > haystack.length())
			return -1;
		if (needle.equals(""))
			return 0;
		int n = haystack.length();
		char c = needle.charAt(0);
		for (int i = 0; i < n; i++) {
			if (haystack.charAt(i) == c) {
				if (i + needle.length() - 1 < n) {
					if (haystack.substring(i, i + needle.length()).equals(needle)) {
						return i;
					}
				}
			}
		}
		return -1;
	}
}
