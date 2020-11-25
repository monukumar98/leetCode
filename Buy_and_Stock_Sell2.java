package Leetcode;

import java.util.Scanner;

public class Buy_and_Stock_Sell2 {

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
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] > arr[i]) {
				sum += (arr[i + 1] - arr[i]);
			}
		}
		return sum;

	}

}
