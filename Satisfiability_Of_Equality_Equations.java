package Leetcode;

import java.util.Scanner;

public class Satisfiability_Of_Equality_Equations {
	static int visited[] = new int[26];
	static {
		for (int i = 0; i < 26; i++) {
			visited[i] = i;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// String str[] = new String[2];
		String str[] = { "a==z", "a==b", "b==c", "c==d", "b==y", "c==x", "d==w", "g==h", "h==i", "i==j", "a==g",
				"j!=y" };

		System.out.println(result(str));
	}

	public static int find(char ch) {
		int idx = ch - 97;
		while (idx != visited[idx]) {
			visited[idx] = visited[idx];
			idx = visited[idx];
		}
		return idx;

	}

	public static boolean result(String equations[]) {
		for (String s : equations) {
			char x = s.charAt(0);
			char y = s.charAt(3);
			if (s.charAt(1) == '=') {
				int idxzero = find(x);
				int idxone = find(y);
				visited[idxzero] = idxone;
			}
		}

		for (String s : equations) {
			char x = s.charAt(0);
			char y = s.charAt(3);
			if (s.charAt(1) == '!') {
				int idxzero = find(x);
				int idxone = find(y);
				if (idxone == idxzero) {
					return false;
				}

			}

		}
		return true;

	}
}