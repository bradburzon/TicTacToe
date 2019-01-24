
public class Model {
	/* double array board
	 * 		[][][]			[1][2][3]
	 *		[][][]			[4][5][6]
	 *		[][][]			[7][8][9]
	 * 1st X player can type 1
	 *		[X][][]			[1][2][3]
	 *		[][][]			[4][5][6]
	 *		[][][]			[7][8][9]
	 * 2nd O player can type 5
	 * 	 	[X][][]			[1][2][3]
	 *		[][O][]			[4][5][6]
	 *		[][][]			[7][8][9]
	 * and so on
	 */
	int[][] board;
	int numOfMoves;
	Player x;
	Player o;
	
	private class Player {
		int wins;
		char letter;
		int moves;
		
		public Player(char letter) {
			this.letter = letter;
		}
		
		public int getWins() {
			return wins;
		}
		
		public void setWins(int wins) {
			this.wins = wins;
		}
		
		public char getLetter() {
			return letter;
		}
		
		public void setLetter(char letter) {
			this.letter = letter;
		}
		
		public int getMoves() {
			return moves;
		}
		
		public void setMoves(int moves) {
			this.moves = moves;
		}
		
	}
	
	public Model() {
		board = new int[3][3];
		numOfMoves = 0;
		x = new Player('X');
		o = new Player('O');
		
	}
	
	
	//Checks the state of the board if either X or O win with three straight across
	// and if number of moves is 9 which means a tie
	boolean checkWin(){
		return false;
	}
	
	private void switchWhoGoesFirst() {
	}
	

	
}
