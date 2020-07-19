/** A class that solves the Towers of Hanoi problem.
	https://en.wikipedia.org/wiki/Tower_of_Hanoi
*/

import java.util.Scanner;

public class TowersOfHanoi {
	/** Recursive method for "moving" disks.
		pre: startPeg, destPeg, tempPeg are different.
		@param n is the number of disks
		@param startPeg is the starting peg
		@param destPeg is the destination peg
		@param tempPeg is the temporary peg
		@return a string all the required disk moves
	*/
	public static String showMoves(int n, String startPeg, String destPeg, String tempPeg) {
		if (n == 1) {
			return "Move disk 1 from peg " + startPeg + " to peg " + destPeg + "\n";
		}else { // Recursive step
			return showMoves(n - 1, startPeg, tempPeg, destPeg)
				+ "Move disk " + n + " from peg " + startPeg
				+ " to peg " + destPeg + "\n"
				+ showMoves(n - 1, tempPeg, destPeg, startPeg);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of disks: ");
		int nDisks = in.nextInt();
		String moves = showMoves(nDisks, "Left", "Right", "Middle");
		System.out.println(moves);
	}
}