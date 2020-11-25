package Leetcode;

import java.util.*;

public class Sequential_Digits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int low = sc.nextInt();
		int high = sc.nextInt();
		System.out.println(sequentialDigits(low, high));

	}

	public static List<Integer> sequentialDigits(int low, int high) {
		String str = "123456789";
		List<Integer> list = new ArrayList<Integer>();
		int lowlen = String.valueOf(low).length();
		int highlen = String.valueOf(high).length();
		for (int i = lowlen; i <= highlen; i++) {
			for (int si = 0; si <= 9 - i; si++) {
				int end = si + i;
				int t = Integer.parseInt(str.substring(si, end));
				if (t>= low && t <= high)
					list.add(t);
			}
		}
		return list;

	}

}
