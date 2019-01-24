
public class View {
	/* Players will see this board, whose turn is it, and the score
	 * --------------------------------------------
	 * Player X's Turn 
	 * 		[][][]			[1][2][3]
	 *		[][][]			[4][5][6]
	 *		[][][]			[7][8][9]
	 * 	Score: X - 0 | O - 0
	 * ---------------------------------------------
	 * Each move will print a similar one with the move incorporated 
	 * --------------------------------------------
	 * Player O's Turn
	 *		[X][][]			[1][2][3]
	 *		[][][]			[4][5][6]
	 *		[][][]			[7][8][9]
	 *	Score: X - 0 | O - 0
	 * ---------------------------------------------
	 * etc.
	 * 
	 * Rules 
	 * TicTacToe
	 * The object of Tic Tac Toe is to get three in a row. 
	 * You play on a three by three game board. The first player
	 * is known as X and the second is O. Players alternate
	 * placing X's and O's on the game board until either opponent 
	 * has three in a row or all nine squares are filled. 
	 * (http://web.cecs.pdx.edu/~bart/cs541-fall2001/homework/tictactoe-rules.html)
	 *   
	 * Help
	 * 1-9 to pick place on the board to place your letter and then press enter.
	 * H to bring out rules and help
	 * R to reset the game and score
	 * S to switch sides
	 */
	Model model;
	
	public View(Model m) {
		model = m;
	}
	
	public String printBoard() {
		return "";
	}
	
	public String printRulesandHelp() {
		return "";
	}
}
