package Leetcode;

import java.util.Scanner;

public class Uncrossed_Lines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		int[] arr1 = new int[m];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		for (int j = 0; j < arr1.length; j++) {
			arr1[j] = sc.nextInt();
		}
		System.out.println(lcsBU(arr, arr1));

	}

	public int lcsTOP(int a[], int b[], int i, int j, int[][] dp) {
		if (i == a.length || j == b.length) {
			return 0;
		}
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		int ans = 0;
		if (a[i] == b[j]) {
			ans += 1 + lcsTOP(a, b, i + 1, j + 1, dp);
		} else {
			ans += Math.max(lcsTOP(a, b, i + 1, j, dp), lcsTOP(a, b, i, j + 1, dp));
		}
		return dp[i][j] = ans;
	}

	public static int lcsBU(int a[], int b[]) {
		int[][] dp = new int[a.length + 1][b.length + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}

		}
		return dp[a.length][b.length];
	}

}
