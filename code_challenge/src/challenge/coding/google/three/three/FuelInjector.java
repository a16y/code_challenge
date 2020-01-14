package challenge.coding.google.three.three;

import java.math.BigInteger;

class Solution {

	/*
	 * Fuel injection perfection
	 * 
	 * Idea here is to do bitwise operations, since the number could be huge
	 */
	public static int solution(String s) {
		BigInteger number = new BigInteger(s);
		BigInteger one = new BigInteger("1");
		BigInteger three = new BigInteger("3");
		BigInteger four = new BigInteger("4");
		int steps = 0;
		while (number.compareTo(one) == 1) {
			if (number.and(one).intValue() == 0) {
				// Divide by two using bitwise operations
				number = number.shiftRight(1);
			} else {
				// Use bit manipulation to create as many 0 from LSB as possible
				if (number.compareTo(three) == 0 || number.mod(four).intValue() == 1) {
					number = number.subtract(one);
				} else {
					number = number.add(one);
				}
			}
			steps++;
		}
		return steps;
	}
}

public class FuelInjector {

	public static void main(String[] args) {
		System.out.println(Solution.solution("123"));
	}
}
