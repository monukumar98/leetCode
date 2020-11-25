package Leetcode;

public class Distinct_Subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numDistinctTD("rabbbit", "rabbit", new int[1000][1000]);
		numDistinct("rabbbit", "rabbit");

	}

	public static int numDistinctTD(String s, String t, int dp[][]) {

		if (s.length() == 0) {
			if (t.length() != 0) {
				return 0;
			} else {
				return 1;
			}
		}
		if (t.length() == 0) {
			return 1;
		}
		if (dp[s.length()][t.length()] != 0) {
			return dp[s.length()][t.length()];
		}
		if (s.charAt(0) == t.charAt(0)) {
			return dp[s.length()][t.length()] = numDistinctTD(s.substring(1), t.substring(1), dp);
		} else {
			return dp[s.length()][t.length()] = numDistinctTD(s.substring(1), t, dp);
		}

	}

	public static int numDistinct(String s, String t) {
		int[][] matrix = new int[t.length() + 1][s.length() + 1];
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[0][i] = 1;
		}
		for (int i = 1; i < matrix.length; i++) {
			matrix[i][0] = 0;
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (t.charAt(i - 1) == s.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1] + matrix[i][j - 1];
				} else
					matrix[i][j] = matrix[i][j - 1];

			}
		}
		System.out.println(matrix[t.length()][s.length()]);
		return matrix[t.length()][s.length()];

	}

}
