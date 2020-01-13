package code_challenge;

class Solution {
	public static int solution(int n) {
/*
 * The grandest staircase of them all
 * 
 * This is a problem of partitioning a number into k distinct values. Algo is
 * N(k,n) = 0, if k>=n
 * N(k,n) = 1, if k=n
 * N(k,n) = N(k+1,n) + N(k+1, n-k)
 */
		int[][] matrix = new int[n+1][n+1];
        matrix[0][0] = 1;
        for(int last =1; last < n+1; last++) {
            for(int left =0; left < n+1; left++) {
                matrix[last][left] = matrix[last-1][left];
                if(left >= last) {
                    matrix[last][left] += matrix[last - 1][left - last];
                }
            }
        } 
        return matrix[n][n] - 1;
	}
}

public class Staircase31 {

	public static void main(String[] args) {
		System.out.println(Solution.solution(200));
	}
}
