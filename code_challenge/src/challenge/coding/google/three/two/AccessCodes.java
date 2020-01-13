package challenge.coding.google.three.two;

class Solution {
	/*
	 * Find the access codes
	 * 
	 */
	public static int solution(int[] inputArr) {
		int count = 0;
		int inputArrLen = inputArr.length;
		int[] matrix = new int[inputArrLen];
		for (int i = 0; i < inputArrLen - 1; i++) {
			for (int j = i + 1; j < inputArrLen; j++) {
				if (inputArr[j] % inputArr[i] == 0) {
					matrix[j] += 1;
					count += matrix[i];
				}
			}
		}
		return count;
	}
}

public class AccessCodes {
	public static void main(String[] args) {
		System.out.println(Solution.solution(new int[] { 1, 2, 3, 4, 5, 6 }));
	}
}
