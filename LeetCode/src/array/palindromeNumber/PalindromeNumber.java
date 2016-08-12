package array.palindromeNumber;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		int base = 1;
		while (x / base >= 10)
			base *= 10;
		while (x > 0) {
			int leftDigit = x / base;
			int rightDigit = x % 10;
			if (leftDigit != rightDigit)
				return false;
			x -= base * leftDigit;
			base /= 100;
			x /= 10;
		}
		return true;
	}

	@Test
	public void test() {
		Assert.assertTrue(isPalindrome(131));
		Assert.assertFalse(isPalindrome(1321));
		Assert.assertTrue(isPalindrome(131));
	}
}
