package countAndSay;

public class CountandSay {
	public String countAndSay(int n) {
		if (n <= 0) {
			return null;
		}
		if (n == 1) {
			return "11";
		}
		StringBuffer sb = new StringBuffer("1");
		StringBuffer temp;
		temp = sb;
		int cur = 0;
		int count = 1;
		for (int i = 0; i < n; i++) {
			char[] chars = sb.toString().toCharArray();
			int s = sb.length();
			char t = sb.charAt(cur);
			while (cur < s) {
				if (cur + 1 != s && chars[cur + 1] == chars[cur]) {
					cur++;
					count++;
				}
				cur++;
				temp.append(t).append(count);
			}
			count = 1;
			sb = temp;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new CountandSay().countAndSay(5));
	}
}
