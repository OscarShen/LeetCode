package string.multiplyStrings;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null || num1.equals("") || num2.equals(""))
			return null;
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int n1 = num1.length(), n2 = num2.length(), product = 0, carry = 0, i, j;
		int[] res = new int[n1 + n2];
		for (i = n1 - 1; i >= 0; --i) {
			carry = 0;
			for (j = n2 - 1; j >= 0; --j) {
				product = carry + (int) (num1.charAt(i) - '0') * (int) (num2.charAt(j) - '0') + res[i + j + 1];
				carry = product / 10;
				res[i + j + 1] = product % 10;
			}
			res[i + j + 1] = carry;
		}

		int cur = 0;
		while (cur < n1 + n2 && res[cur] == 0)
			++cur;
		StringBuilder sb = new StringBuilder();
		while (cur < n1 + n2) {
			sb.append(res[cur]);
			++cur;
		}
		return sb.toString();
	}
}
