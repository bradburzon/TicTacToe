
public class Model {
	/* double array board 
	 * 		[][][]			[1][2][3]
	 *		[][][]			[4][5][6]
	 *		[][][]			[7][8][9]
	 *
	 */
	int[][] board;
	int numOfMoves;
	Player x;
	Player o;
	
	/**
	 * Creates a board, number of moves, and the players
	 */
	public Model() {
		board = new int[3][3];
		numOfMoves = 0;
		x = new Player('X');
		o = new Player('O');
		
	}
	
	
}
