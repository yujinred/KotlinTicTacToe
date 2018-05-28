class GameBoard(private var board: Array<Char> = Array(9, { ' '})) {

	fun printBoard() {
		println(" ${board[0]} | ${board[1]} | ${board[2]} ")
		println("---+---+---")
		println(" ${board[3]} | ${board[4]} | ${board[5]} ")
		println("---+---+---")
		println(" ${board[6]} | ${board[7]} | ${board[8]} ")
	}

	fun getPieceAtPosition(position: Int): Char {
		return board[position]
	}

	fun setPiece(currentPlayer: Char, position: Int) {
		board[position] = currentPlayer
	}

	fun checkWinConditions(): Boolean {
		var result = false
		for (i in 0..2) {
			result = board[i] != ' ' && (((board[i*3] == board[i*3+1]) && (board[i*3] == board[i*3+2])) ||
					(board[i] == board[i+3] && (board[i] == board[i+6])))
			if (result) break
		}

		if (!result) {
			result = board[4] != ' ' && (((board[0] == board[4]) && (board[4] == board[8])) ||
					(board[2] == board[4] && (board[4] == board[6])))
		}

		return result
	}
}