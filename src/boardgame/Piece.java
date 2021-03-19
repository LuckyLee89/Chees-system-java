package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	

	public Piece() {
		
	}


	public Piece(Board board) {

		this.board = board;
	}


	protected Board getBoard() {//tabuleiro restrito a classe e as subclasses 
		return board;
	}
	
	
	
	
}
