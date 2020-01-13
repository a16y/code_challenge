package challenge.coding.google.two.one;

class Solution {
	/*
	 *Lovely lucky lambs
	 *
	 * When generous, keep paying double the amount to senior henchman
	 * When stingy, follow the Fibonacci series to pay all the henchmen
	 * Difference between them is the answer.
	 */
	public static int solution(int total_lambs) {
		int generousCount = getGenerousCount(total_lambs);
		int stingyCount = getStingyCount(total_lambs);
		System.out.println("stingyCount, generousCount: " + stingyCount + ", " + generousCount);
		return stingyCount - generousCount;
	}

	// When generous, keep doubling the amount to senior
	private static int getGenerousCount(int total_lambs) {
		int number = 0;
		int totalDistributedLambs = 1;
		while (totalDistributedLambs <= total_lambs) {
			number++;
			totalDistributedLambs += (int) Math.pow(2, number);
		}
		return number;
	}

	// When stingy, follow fibonacci series
	private static int getStingyCount(int total_lambs) {
		int number = 1;
		int totalDistributedLambs = 1;
		while (totalDistributedLambs <= total_lambs) {
			int currentLambs = calculateFibonacci(number);
			number++;
			totalDistributedLambs += currentLambs;
		}
		return number - 1;
	}

	private static int calculateFibonacci(int number) {
		if (number <= 1) {
			return 1;
		} else {
			return calculateFibonacci(number - 1) + calculateFibonacci(number - 2);
		}
	}
}

public class Lambs {
	public static void main(String[] args) {
		int count = Solution.solution(10);
		System.out.println(count);
	}
}
