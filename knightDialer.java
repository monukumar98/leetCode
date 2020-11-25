package Leetcode;

import java.util.HashMap;

public class knightDialer {
	int[] rx = { 1, -1, 1, -1, -2, -2, 2, 2 };
	int[] cy = { 2, 2, -2, -2, 1, -1, 1, -1 };

	public int knightdialer(int n) {
		int ans = 0;
		HashMap<String, Integer> dp = new HashMap<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				ans = (ans + phonekey(n - 1, i, j, dp)) % 1000000007;
			}
		}
		return ans;

	}

	public int phonekey(int n, int r, int c, HashMap<String, Integer> dp) {
		if (r < 0 || c < 0 || r > 3 || c > 2 || (r == 3 && c == 2) || (r == 3 && c == 0)) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		String str = n + "|" + r + "|" + c;
		// System.out.println(str);
		if (dp.containsKey(str)) {
			return dp.get(str);
		}
		int ans = 0;

		for (int i = 0; i < 8; i++) {
			ans = (ans + phonekey(n - 1, r + rx[i], c + cy[i], dp)) % 1000000007;
		}
		dp.put(str, ans);
		return (ans) % 1000000007;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		knightDialer kn = new knightDialer();
		System.out.println(kn.knightdialer(100));

	}

}
