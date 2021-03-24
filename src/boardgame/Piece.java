package boardgame;

public abstract class Piece {
	
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
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		
		boolean[][] mat = possibleMoves();
		for(int i=0; i< mat.length;i++) {// percorrendo a matriz para verificar se existe alguma posicao que seja verdadeira 
			for(int j=0; j<mat.length;j++) {
				if(mat[i][j]) {// se a matriz for verdadeira
					return true;
				}
			}
		}
		return false;// se a varredura da matriz acabar e não retornar true em nenhum lugar
	}
}
