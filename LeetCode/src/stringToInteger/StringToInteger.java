package stringToInteger;

public class StringToInteger {
	public int myAtoi(String str) {
		if (str == null)
			return 0;
		str = str.trim();
		if (str.equals(""))
			return 0;
		char[] c = str.toCharArray();
		boolean sign = true;// true为正数，false为负数
		int i;
		long res = 0;
		if (c[0] == '-') {
			i = 1;
			sign = false;
		} else if (c[0] == '+') {
			i = 1;
			sign = true;
		} else if (48 <= c[0] && c[0] <= 57) {
			i = 0;
		} else {
			return 0;
		}
		for (; i < c.length; i++) {
			if (!(48 <= c[i] && c[i] <= 57))
				break;
			int t = c[i] - 48;
			res = res * 10 + t;
			if (res > Integer.MAX_VALUE)
				break;
		}
		if (sign)
			if (res > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else
				return (int) res;
		else {
			if (-res < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			else
				return (int) -res;
		}
	}
}
