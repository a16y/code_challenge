package challenge.coding.google.two.two;

class Solution {
	/*
	 * En route salute
	 * 
	 */
	public static int solution(String s) {
		char[] charArr = s.toCharArray();
		int rightArrows = 0;
		int salutes = 0;
		for (char c : charArr) {
			if (c == '>') {
				rightArrows++;
			}
			// A leftArrow soldier will salute to only those rightArrow soldiers
			// who are to the left of him in the line at that point
			if (c == '<') {
				salutes += rightArrows * 2;
			}
		}
		return salutes;
	}
}

public class Salute {
	public static void main(String[] args) {
		int count = Solution.solution("<<>><");
		System.out.println(count);
	}
}
