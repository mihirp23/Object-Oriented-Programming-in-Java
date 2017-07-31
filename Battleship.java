
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
	 * ------------------------------- battle() -------------------------------
	 */
	public void battle() {
		
		System.out.println("Battle!!!");
		
		int x, y;
		Scanner in = new Scanner(System.in);
		boolean isPlayerTurn = true;
		
		int computerShips = 5, userShips = 5;
		
		do {
			
			this.displayOcean();
			
			if (isPlayerTurn) {
				System.out.println("YOUR TURN!");
			    System.out.println("enter X coordinate of the attack position ");
			    x = in.nextInt();
			    System.out.println("enter Y coordinate of the attack position ");
			    y = in.nextInt();
			}
			else {
				System.out.println("COMPUTER's TURN!");
				x = (int) (Math.random() * 10);
				y = (int) (Math.random() * 10); 
			}
			   
			// invalid coordinates
			if (x < 0 || x > 9 || y < 0 || y > 9) {
			   continue;
			}
			    
			// attacked a position that was previously attacked.
			if (ocean[x][y] == 'x') {
			    continue;
			}
			
			
			// interact with user on how the attack happened.
			if (ocean[x][y] == '#'){
				if (isPlayerTurn) {
					System.out.println("Boom, your sunk a computer ship!");
				}
				else {
					System.out.println("Computer sunk its own ship!");
				}
			    computerShips--;
			}
			else if (ocean[x][y] == '@') {
				if (isPlayerTurn) {
					System.out.println("You sunk your own ship! :( ");
				}
				else {
					System.out.println("Computer sunk your ship!");
				}
			    userShips--;
			}
			else {
				System.out.println("Missed!!!");
			}
			
			ocean[x][y] = 'x';
			
			// switch between player and computer
			if (isPlayerTurn) {
				isPlayerTurn = false;
			}
			else {
				isPlayerTurn = true;
			}
			
		} while (userShips > 0 && computerShips > 0);
		
		System.out.println();
		System.out.println("============================================");
		if (userShips == 0) {
			System.out.println("Computer has won!");
		}
		else {
			System.out.println("User has won!");
		}
		System.out.println("============================================");
		
		
	}

	/*
	 * ---------------------------- placeComputerShips() -----------------------
	 */
	public void placeComputerShips() {
		int num_of_ships = 0;
        
		System.out.println("Computer is deploying ships!");
		while (num_of_ships < 5) {
			int x = (int) (Math.random() * 10);
			int y = (int) (Math.random() * 10);

			if (ocean[x][y] != '*') {
				continue;
			}
            
			System.out.println("Ship deployed...");
			ocean[x][y] = '#';
			num_of_ships++;
		}
		
		System.out.println("-----------------------------------------------");
	}

	public static void main(String[] args) {
		Battleship b = new Battleship();
		b.displayOcean();
		b.placeUserShips();
		b.placeComputerShips();
		b.battle();
	}
}
