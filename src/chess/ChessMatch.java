package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {

		board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getPieces() {

		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);// downcast para interpretar como uma peça de xadrez
			}
		}
		return mat;
	}

	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition ) {
		
		Position source= sourcePosition.toPosition();// convertendo para posição da matrix
		Position target= targetPosition.toPosition();//convertendo para posição da matrix
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece; // downcast da peça tipo piece para ChessPiece
	}
	
	private void validateSourcePosition(Position position) {
		
		if(!board.thereIsAPiece(position)) {// se não existir uma peça nessa posicao
			
			throw new ChessException("There is no piece on sourcePosition");
		}
	}
	
	private Piece makeMove(Position sourcePosition, Position targePosition) {
		
		Piece p= board.removePiece(sourcePosition);// remove a peça da origem ou melhor que movemos
		Piece capturedPiece = board.removePiece(targePosition);// removendo a peça no destion ou seja capturada 
		board.placePiece(p,targePosition);// colacando a peça movida no lugar da capturada
		return capturedPiece;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {

		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	private void initialSetup() {

		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));

		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
