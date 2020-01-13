package challenge.coding.google.one.one;

class Solution {

	/*
	 * The cake is not a lie
	 * 
	 * The algo here is to calculate the longest prefix which is also a suffix. Part
	 * of KMP search algo Borrowed the LPS code from geeksforgeeks
	 * 
	 * After that, find the shortest non-overlapping pattern because we want to have
	 * maximum pieces of cake. If the substring divides the string into exact
	 * pieces, return that number. Else return 1
	 */
	public static int solution(String inputStr) {
		int inputStrLen = inputStr.length();
		int lps[] = getLPSArray(inputStr);

		int patternLen = lps[inputStrLen - 1];

		// Length of shortest repeating non-overlapping pattern within the given pattern
		int shortestPatternLen = inputStrLen - patternLen;

		if (patternLen > 0 && inputStrLen % (shortestPatternLen) == 0) {
			return inputStrLen / (shortestPatternLen);
		} else {
			return 1;
		}
	}

	private static int[] getLPSArray(String str) {
		int strLen = str.length();
		int lps[] = new int[strLen];

		// length of the previous longest prefix suffix
		int len = 0;

		int i = 1;

		// lps[0] is always 0
		lps[0] = 0;

		// the loop calculates lps[i] from i = 1 to strLen-1
		while (i < strLen) {
			if (str.charAt(i) == str.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else { // (pat[i] != pat[len])
				if (len != 0) {
					// This is tricky. Consider the
					// example AAACAAAA and i = 7.
					len = lps[len - 1];

					// Also, note that we do
					// not increment i here
				} else { // if (len == 0)
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
}

public class Cake {
	public static void main(String[] args) {
		int count = Solution.solution("abcabcabcabc");
		System.out.println(count);
	}
}
