
/* Name : Mihir Patel
 * Date : July 25, 2017
 * File : Battleship.java
 */

import java.util.Scanner;

public class Battleship {
	public static final int ROWS = 10;
	public static final int COLS = 10;
	private char[][] ocean = new char[ROWS][COLS];

	/*
	 * ----------------------------- Battleship() ----------------------------
	 */
	public Battleship() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				ocean[i][j] = '*';
			}
		}
	}

	/*
	 * ---------------------------- displayOcean() ---------------------------
	 */
	public void displayOcean() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.print(ocean[i][j]);
			}
			System.out.println();
		}
	}

	/*
	 * --------------------------- placeUserShips() ----------------------------
	 */
	public void placeUserShips() {
		Scanner in = new Scanner(System.in);

		int num_of_ships = 0;
		System.out.println("Deploy your ships...");
		while (num_of_ships < 5) {
			System.out.println("Enter X coordinate for ship # " + (num_of_ships + 1));
			int x = in.nextInt();
			System.out.println("Enter Y coordinate for ship # " + (num_of_ships + 1));
			int y = in.nextInt();

			// out of bounds so prompt again...
			if (x < 0 || x > ROWS || y < 0 || y > COLS) {
				System.out.println("Please enter a valid coordinate!");
				continue;
			}

			// coordinate is already occupied. try again...
			if (ocean[x][y] != '*') {
				System.out.println("Coordinate is already occupied!");
				continue;
			}

			ocean[x][y] = '@';
			num_of_ships++;
		}
	}

	/*
	 * ---------------------------- placeComputerShips() -----------------------
	 */
	public void placeComputerShips() {
		int num_of_ships = 0;

		while (num_of_ships < 5) {
			int x = (int) (Math.random() * 10);
			int y = (int) (Math.random() * 10);

			if (ocean[x][y] != '*') {
				continue;
			}

			ocean[x][y] = 'x';
			num_of_ships++;
		}
	}

	public static void main(String[] args) {
		Battleship b = new Battleship();
		b.displayOcean();
		b.placeUserShips();
		b.displayOcean();
		b.placeComputerShips();
		b.displayOcean();
	}
}
