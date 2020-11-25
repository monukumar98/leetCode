package Leetcode;

import java.util.Scanner;

public class Buy_and_Stock_Sell1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {

			arr[i] = sc.nextInt();
		}
		System.out.println(maxProfit(arr));

	}

	public static int maxProfit(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max_profit = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] < min) {
				min = arr[i];
			} else if (arr[i] - min > max_profit) {
				max_profit = arr[i] - min;
			}
		}
		return max_profit;

	}

}
