package zigZagConversion;

import org.junit.Test;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s == null || numRows <= 1 || s.equals(""))
			return s;
		int partCapacity = 2 * numRows - 2;
		char[] input = s.toCharArray();
		int n = input.length;
		int partCount = n / partCapacity + 1;
		int numColumn = partCount * (numRows - 1);

		char[][] res = new char[numRows][numColumn];
		int i = 0, j = 0;

		int cur = 1;
		for (int index = 0; index < n; index++) {
			if (cur < numRows) {
				res[i++][j] = input[index];
			} else if (cur <= partCapacity) {
				res[i--][j++] = input[index];
			}
			cur++;
			if (cur == partCapacity + 1) {
				cur = 1;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int a = 0; a < numRows; a++) {
			for (int b = 0; b < numColumn; b++) {
				if (res[a][b] != '\u0000') {
					sb.append(res[a][b]);
				}
			}
		}
		return sb.toString();
	}

	@Test
	public void test() {
		String str = convert("A", 1);
		System.out.println(str);
	}
}
