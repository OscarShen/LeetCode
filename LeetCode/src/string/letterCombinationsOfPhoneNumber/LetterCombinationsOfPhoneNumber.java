package string.letterCombinationsOfPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.equals("") || digits.contains("0") || digits.contains("1"))
			return new ArrayList<>();
		String[] charMap = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> res = new ArrayList<>();
		for (int i = 0; i < charMap[digits.charAt(0) - '0'].length(); i++) {
			res.add(charMap[digits.charAt(0) - '0'].substring(i, i + 1));
		}
		for (int i = 1; i < digits.length(); i++) {
			int digit = digits.charAt(i) - '0';
			List<String> tempRes = new ArrayList<>();
			for (String str : res) {
				for (int j = 0; j < charMap[digit].length(); j++) {
					String tempString = str + charMap[digit].charAt(j);
					tempRes.add(tempString);
				}
			}
			res = tempRes;
		}
		return res;
	}
}
