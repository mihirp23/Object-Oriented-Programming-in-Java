/* Name : Mihir Patel
 * Date : July 25, 2017
 * File : Battleship.java
 */

public class Battleship {
	public static final int ROWS = 10;
	public static final int COLS = 10;
	private char [][] ocean = new char[ROWS][COLS];

	/* ----------------------------- Battleship() ---------------------------- */
	public Battleship() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				ocean[i][j] = '*';
			}
		}
	}
	
	/* ---------------------------- displayOcean() --------------------------- */
    public void displayOcean() {
    	for (int i = 0; i < ROWS; i++) {
    		for (int j = 0; j < COLS; j++) {
    			System.out.print(ocean[i][j]);
    		}
    		System.out.println();
    	}
    }
    
    public static void main (String [] args) {
        Battleship b = new Battleship();
        b.displayOcean();
    }
}
