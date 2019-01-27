public class Player {
		int wins;
		char letter;
		int numMoves;
		
		
		/** Creates a player with the given letter
		 * @param char The letter of the player
		 */
		public Player(char letter) {
			this.letter = letter;
			wins = 0;
			numMoves = 0;
		}
		
		/**Gives the wins of the player
		 * @return The number of wins 
		 */
		public int getWins() {
			return wins;
		}
		
		/**Sets the win to the given number
		 * @param int Number of wins
		 */
		public void setWins(int wins) {
			this.wins = wins;
		}
		
		/**Gives the letter of the player
		 *@return The letter of the Player
		 */
		public char getLetter() {
			return letter;
		}
		
		/**Sets the letter of player
		 * @param char The letter for the player
		 */
		public void setLetter(char letter) {
			this.letter = letter;
		}
		
		/**Gives the number of the player's moves
		 * @return The number of moves of the player
		 */
		public int getMoves() {
			return numMoves;
		}
		
		/**Sets the number of moves of the player
		 * @param int The value of the player's moves
		 */
		public void setMoves(int moves) {
			numMoves = moves;
		}
		
	}