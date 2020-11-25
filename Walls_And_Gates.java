package Leetcode;

import java.util.Scanner;

public class Walls_And_Gates {

	public static void main(String[] args) {
		// TODO Auto-generated method stubS
		Scanner sc = new Scanner(System.in);
		int room[][] = { { 2147483647, -1, 0, 2147483647 },
				        { 2147483647, 2147483647, 2147483647, -1 },
				        { 2147483647, -1, 2147483647, -1 }, 
				        { 0, -1, 2147483647, 2147483647 } };

		wallsAndGates(room);
	}

	public static void wallsAndGates(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0) {
					fillroomid(rooms, i, j, 0);
				}
			}
		}
		display(rooms);

	}

	private static void fillroomid(int[][] rooms, int i, int j, int k) {
		if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < k) {
			return;
		}
		rooms[i][j] = k;

		fillroomid(rooms, i - 1, j, k + 1);
		fillroomid(rooms, i + 1, j, k + 1);
		fillroomid(rooms, i, j + 1, k + 1);
		fillroomid(rooms, i, j - 1, k + 1);

	}

	public static void display(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				System.out.print(rooms[i][j] + " ");
			}
			System.out.println();
		}

	}
}
