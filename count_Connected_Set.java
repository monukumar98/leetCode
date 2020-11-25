package Leetcode;

import java.util.Scanner;

public class count_Connected_Set {
	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();

			int M[][] = new int[n][n];
			for (int i = 0; i < M.length; i++) {
				for (int j = 0; j < M[0].length; j++) {
					M[i][j] = sc.nextInt();
				}
			}

			System.out.println(count_conneted_Set(M));
		}
	}

	public static boolean issafe(int[][] M, int row, int col, boolean visited[][]) {
		return (row >= 0 && row < M.length && col >= 0 && col < M[0].length && M[row][col] == 1 && !visited[row][col]);
	}

	public static void DFS(int M[][], int row, int col, boolean visited[][]) {
		// These arrays are used to get row and column numbers
		// of 8 neighbors of a given cell
		int rowNbr[] = new int[] { -1, 0, 0, 1, -1, -1, 1, 1 };
		int colNbr[] = new int[] { 0, -1, 1, 0, 1, -1, 1, -1 };
//		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 }; 
//        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 }; 
  
        // Mark this cell as visited 

		// Mark this cell as visited
		visited[row][col] = true;

		// Recur for all connected neighbours
		for (int k = 0; k < 8; ++k)
			if (issafe(M, row + rowNbr[k], col + colNbr[k], visited))
				DFS(M, row + rowNbr[k], col + colNbr[k], visited);
	}

	public static int count_conneted_Set(int M[][]) {
		// Make a bool array to mark visited cells.
		// Initially all cells are unvisited
		boolean visited[][] = new boolean[M.length][M[0].length];

		// Initialize count as 0 and travese through the all cells
		// of given matrix
		int count = 0;
		for (int i = 0; i < M.length; ++i)
			for (int j = 0; j < M[0].length; ++j)
				if (M[i][j] == 1 && !visited[i][j]) // If a cell with
				{ // value 1 is not
					// visited yet, then new island found, Visit all
					// cells in this island and increment island count
					DFS(M, i, j, visited);
					++count;
				}

		return count;
	}
}
