package countAndSay;

public class CountandSay {
	String msg;

	private int getCount(int begin, String str) {
		char c = str.charAt(begin);
		int count = 0;
		int m = str.length();
		for (; begin < m; begin++) {
			if (c == str.charAt(begin)) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	public String countAndSay(int n) {
		if (n == 0) {
			return null;
		}
		if (n == 1) {
			return "1";
		}
		msg = "1";
		for (int i = 2; i <= n; i++) {
			int begin = 0;
			StringBuilder sb = new StringBuilder();
			int m = msg.length();
			while (begin < m) {
				char c = msg.charAt(begin);
				int count = getCount(begin, msg);
				sb.append(count);
				sb.append(c);
				begin += count;
			}
			msg = sb.toString();
		}
		return msg;
	}
}
