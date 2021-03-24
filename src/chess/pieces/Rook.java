package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) { // construtor para repasasr a chamada para a superclasse
		super(board, color);

	}
	
	@Override
	public String toString() {// convertendo uma torre para String
		
		return "R";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return null;
	}

	
}
